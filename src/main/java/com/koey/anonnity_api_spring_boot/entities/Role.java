package com.koey.anonnity_api_spring_boot.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(name = "unq_flag", columnNames = "flag"),
                @UniqueConstraint(name = "unq_name", columnNames = "name")
        }
)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer flag;
    @Column(nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Role role)) return false;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Integer getId() {
        return id;
    }

    public Integer getFlag() {
        return flag;
    }

    public String getName() {
        return name;
    }
}