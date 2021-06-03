package com.epam.tct.model;

import java.util.Arrays;

public enum Role {
    ADMIN, USER, GUEST;

    public static Role getRole(User user) {
        int roleId = user.getRoleId()-1;
        return Role.values()[roleId];
    }

    public String getName() {
        return name().toLowerCase();
    }

}
