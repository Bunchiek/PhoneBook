package org.example;

import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
public class FullName {

    private  String fullName;

    public FullName setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }
}
