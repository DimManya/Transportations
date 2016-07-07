package ua.com.transportations.configs;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by d.fedorov on 24.06.16.
 */
@Order(2)
public class SpringInitializer extends AbstractSecurityWebApplicationInitializer {

}
