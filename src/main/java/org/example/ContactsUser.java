package org.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class ContactsUser {

    private List<Contact> contacts;

    public ContactsUser(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
