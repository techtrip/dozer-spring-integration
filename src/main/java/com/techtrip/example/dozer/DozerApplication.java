package com.techtrip.example.dozer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties
public class DozerApplication {

    // Direct Value Injection
	@Value("${spring.application.name}")
	void setApplicationName(String applicationName) {
		System.out.println("App Name From Auto-Config in Application.yml: " + applicationName);
	}


    /**
     * Injection of properties using Configuration Properties
     * @param configurationProjectProperties
     */
	@Autowired
	void setConfigurationProjectProperties(ConfigurationProjectProperties configurationProjectProperties) {
		System.out.println("App Name: " + configurationProjectProperties.getName());
        System.out.println("Marker: " + configurationProjectProperties.getMarker());
	}


	public static void main(String[] args) {
		SpringApplication.run(DozerApplication.class, args);
	}

}

@Component
// Map everything with spring.application to these config props
@ConfigurationProperties("spring.application")
class ConfigurationProjectProperties {

	private String name;
	private String marker;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
}
