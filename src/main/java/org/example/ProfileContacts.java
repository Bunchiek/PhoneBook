package org.example;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
//@Component
public class ProfileContacts {

    private final Contacts contacts;

    public ProfileContacts(Contacts contacts) {
        this.contacts = contacts;
    }
}
