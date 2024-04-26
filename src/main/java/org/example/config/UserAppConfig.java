package org.example.config;

import org.example.Contact;
import org.example.Contacts;
import org.example.ContactsUser;
import org.springframework.context.annotation.*;

import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
@Profile("user")
public class UserAppConfig {

//    @Bean
//    public Contacts contacts(){
//        return new ContactsUser();
//    }

@Bean
public List<Contact> contacts(){
    List<Contact> list = List.of(new Contact(), new Contact(), new Contact());
    return list;
}

}
