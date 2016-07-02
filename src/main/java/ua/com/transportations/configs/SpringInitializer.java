package ua.com.transportations.configs;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by d.fedorov on 24.06.16.
 */
public class SpringInitializer extends AbstractSecurityWebApplicationInitializer {

    public SpringInitializer() {
        super(SecurityConfigurator.class);
    }
}
