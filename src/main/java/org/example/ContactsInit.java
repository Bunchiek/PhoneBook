package org.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ContactsInit implements Contacts{
    private List<Contact> contacts = new ArrayList<>();
}
