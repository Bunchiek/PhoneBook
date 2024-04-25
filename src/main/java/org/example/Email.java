package org.example;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Email {

    private  String email;

    public Email setEmail(String email) {
        this.email = email;
        return this;
    }
}
