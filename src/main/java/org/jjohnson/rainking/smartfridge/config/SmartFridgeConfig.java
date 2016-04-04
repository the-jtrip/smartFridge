package org.jjohnson.rainking.smartfridge.config;

import org.jjohnson.rainking.smartfridge.servicesImpl.SmartFridgeManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.jjohnson.rainking.smartfridge")
public class SmartFridgeConfig {

	@Bean
	public SmartFridgeManagerImpl ticketServiceImpl() {
		return new SmartFridgeManagerImpl();
	}

}
