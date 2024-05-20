package com.example.demo;

import com.example.demo.Config.RibbonConfiguration;
import com.netflix.client.IClient;
import com.netflix.client.config.IClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "server", configuration = RibbonConfiguration.class)

public class RibbonLoadBalancer {

	public static void main(String[] args) {
		SpringApplication.run(RibbonLoadBalancer.class, args);
	}

}
