package com.mani.securebank.model;

import java.util.Set;

public enum Role {

    USER(
            Set.of(
                    Permission.ACCOUNT_READ
            )
    ),

    ADMIN(
            Set.of(
                    Permission.ACCOUNT_READ,
                    Permission.ACCOUNT_CREATE,
                    Permission.ACCOUNT_UPDATE,
                    Permission.ACCOUNT_DELETE
            )
    );

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
