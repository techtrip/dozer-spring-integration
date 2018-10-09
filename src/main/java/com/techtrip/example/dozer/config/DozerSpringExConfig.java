package com.techtrip.example.dozer.config;

import com.techtrip.example.dozer.converters.MegaDateConverter;
import com.techtrip.example.dozer.util.WidgetHolder;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DozerSpringExConfig {

    @Bean(name="megaDateConverter")
    public MegaDateConverter<LocalDateTime> megaDateConverter() {
        return new MegaDateConverter(LocalDateTime.class);
    }

    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(@Value("classpath*:mappings/*mappings.xml") Resource[] resources) throws Exception {
        final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
        // Other configurations
        dozerBeanMapperFactoryBean.setMappingFiles(resources);
        return dozerBeanMapperFactoryBean;
    }

    @Bean
    Map<Integer, WidgetHolder> widgetStore() {
        return new HashMap<>();
    }
}
