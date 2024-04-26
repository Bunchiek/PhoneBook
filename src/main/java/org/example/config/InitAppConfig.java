package org.example.config;

import org.example.Contact;
import org.example.Contacts;
import org.example.ContactsInit;
import org.example.ContactsUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
@Profile("init")
public class InitAppConfig {

//    @Bean
//    public Contacts contacts(){
//        return new ContactsInit();
//    }

@Bean
public List<Contact> contacts(){
    List<Contact> list = List.of(new Contact(), new Contact());
    return list;
}

}
