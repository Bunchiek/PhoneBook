package org.example;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumber {

    private String number;

    public PhoneNumber setNumber(String number) {
        this.number = number;
        return this;
    }
}
