package com.koey.anonnity_api_spring_boot.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(
        name = "member_roles",
        uniqueConstraints = @UniqueConstraint(name = "unq_member_role", columnNames = {"member_id", "role_id"})
)
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MemberRole that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
