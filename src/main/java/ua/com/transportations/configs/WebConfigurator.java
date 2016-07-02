package ua.com.transportations.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by d.fedorov on 29.06.16.
 */
@Configuration
@EnableWebMvc
@ComponentScan("ua.com.transportations.controllers")
public class WebConfigurator {
}
