package com.dopsri.spring.employee.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dopsri.spring.employee.model.Department;
import com.dopsri.spring.employee.model.Employee;
import com.dopsri.spring.employee.model.EmployeeInfo;
import com.dopsri.spring.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	@LoadBalanced
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Autowired
    private LoadBalancerClient loadBalancer;
 
    @GetMapping(value = "/")
    public String home() { 
        return "<a href='showAllServiceIds'>Show All Service Ids</a>";
    }
    
    @GetMapping(value = "/showAllServiceIds")
    public String showAllServiceIds() {
 
        List<String> serviceIds = this.discoveryClient.getServices();
 
        if (serviceIds == null || serviceIds.isEmpty()) {
            return "No services found!";
        }
        String html = "<h3>Service Ids:</h3>";
        for (String serviceId : serviceIds) {
            html += "<br><a href='showService?serviceId=" + serviceId + "'>" + serviceId + "</a>";
        }
        return html;
    }
    
    @ResponseBody
    @RequestMapping(value = "/showService", method = RequestMethod.GET)
    public String showFirstService(@RequestParam(defaultValue = "") String serviceId) {
 
        // (Need!!) eureka.client.fetchRegistry=true
        List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
 
        if (instances == null || instances.isEmpty()) {
            return "No instances for service: " + serviceId;
        }
        String html = "<h2>Instances for Service Id: " + serviceId + "</h2>";
 
        for (ServiceInstance serviceInstance : instances) {
            html += "<h3>Instance: " + serviceInstance.getUri() + "</h3>";
            html += "Host: " + serviceInstance.getHost() + "<br>";
            html += "Port: " + serviceInstance.getPort() + "<br>";
        }
 
        return html;
    }
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping(value = "/list")
	public List<EmployeeInfo> getEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream()
				.map(employee -> createEmployeeBean(employee))
				.collect(Collectors.toList());
		
	}

	private EmployeeInfo createEmployeeBean(Employee employee) {
		ServiceInstance instance = this.loadBalancer.choose("department-service");
		URI departmentUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
		System.out.println(departmentUri);
		Department department = restTemplate.getForObject(departmentUri + "/department/" + employee.getDepartmentNumber() , Department.class);
		return new EmployeeInfo(employee.getEmployeeNumber(),
				employee.getEmployeeName(),
				employee.getSalary(),
				department.getDepartmentName()
				);
	}

}
