package ua.com.transportations.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by d.fedorov on 28.06.16.
 */
@Configuration
public class PropertyConfigurator {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        String activeProfile = System.getProperty("spring.profiles.active", "test");
        String propertiesFilename = "prop-" + activeProfile + ".properties";

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new ClassPathResource(propertiesFilename));
        return configurer;
    }

}
