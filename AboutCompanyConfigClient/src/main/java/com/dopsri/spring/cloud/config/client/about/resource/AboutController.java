package com.dopsri.spring.cloud.config.client.about.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/about")
public class AboutController {
	
	 @Value("${text.copyright: Default Copyright}")
	 private String copyright;
	 
	@GetMapping(value = "/showConfig")
	public String showConfig() {
        String configInfo = "Copy Right: " + copyright; 
        return configInfo;
    }
}
