package ua.com.transportations.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

/**
 * Created by d.fedorov on 05.06.16.
 */
@Configuration
@ComponentScan(basePackages = {"ua.com.transportations.services"})
@Import({PropertyConfigurator.class, DBConfigurator.class, SecurityConfigurator.class})

@EnableScheduling
public class AppConfigurator {


    @Bean
    public JavaMailSenderImpl javaMailSenderImpl(
            @Value("${smtp.host}") String host,
            @Value("${smtp.port}") Integer port,
            @Value("${smtp.username}") String username,
            @Value("${smtp.password}") String password) {

        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setHost(host);
        mailSenderImpl.setPort(port);
        mailSenderImpl.setUsername(username);
        mailSenderImpl.setPassword(password);
        Properties javaMailProps = new Properties();
        javaMailProps.put("mail.smtp.auth", true);
        javaMailProps.put("mail.smtp.starttls.enable", true);
        mailSenderImpl.setJavaMailProperties(javaMailProps);
        return mailSenderImpl;
    }


}
