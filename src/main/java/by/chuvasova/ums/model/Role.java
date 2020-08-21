package by.chuvasova.ums.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
