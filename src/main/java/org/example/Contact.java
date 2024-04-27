package org.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Contact {
    private String fullName;
    private String phoneNumber;
    private String email;

    public Contact(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
