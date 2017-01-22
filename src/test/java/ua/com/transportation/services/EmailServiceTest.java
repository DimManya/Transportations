package ua.com.transportation.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.com.transportations.configs.AppConfigurator;
import ua.com.transportations.services.EmailService;

/**
 * Created by d.fedorov on 27.06.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurator.class})
@ActiveProfiles(profiles = "test")
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    public void sendEmail() {
        emailService.sendMail("dimmanya@gmail.com", "test", "Email Sending passed successfully");
    }

}
