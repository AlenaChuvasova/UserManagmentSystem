package by.chuvasova.ums.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserState {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
