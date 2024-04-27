package org.example.config;

import org.example.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:application.properties")
@Profile("init")
public class InitAppConfig {

@Bean
public List<Contact> contacts(){

    StringBuilder builder = new StringBuilder();
    List<Contact> list = new ArrayList<>();
    List<String> lines = null;
    try {
        lines = Files.readAllLines(Paths.get("src/main/resources/default-contacts.txt"));
        lines.forEach(s-> builder.append(s).append('\n'));
        lines.forEach(s->{
            String[] strings = s.split(";");
            list.add(new Contact(strings[0].trim(),strings[1].trim(),strings[2].trim()));
        });

    } catch (IOException e) {
        throw new RuntimeException(e);
    }


    return list;
}

}
