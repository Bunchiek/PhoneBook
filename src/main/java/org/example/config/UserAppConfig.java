package org.example.config;

import org.example.Contact;
import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
@Profile("user")
public class UserAppConfig {

    @Bean
    public List<Contact> contacts() {
        return new ArrayList<>();
    }

}
