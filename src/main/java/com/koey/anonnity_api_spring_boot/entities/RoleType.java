package com.koey.anonnity_api_spring_boot.entities;

public enum RoleType {
    None(0, "ROLE_NONE"),
    Member(1, "ROLE_MEMBER"),
    Manager(2, "ROLE_MANAGER")
    ;

    private final String name;
    private final Integer flag;

    RoleType(Integer flag, String name) {
        this.flag = flag;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getFlag() {
        return flag;
    }
}
