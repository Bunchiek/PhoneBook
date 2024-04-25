package org.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Setter
@Getter
public class Contact {

    private FullName fullName;
    private PhoneNumber phoneNumber;
    private Email email;

    public Contact(FullName fullName, PhoneNumber phoneNumber, Email email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
