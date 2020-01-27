package com.dopsri.spring.cloud.eureka.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eureka-server")
public class EurekaServerRestController {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping(value = "/services")
	private List<String> getServiceInstances() {
		return discoveryClient.getServices();
	}
}
