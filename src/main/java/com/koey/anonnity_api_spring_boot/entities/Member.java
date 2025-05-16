package com.koey.anonnity_api_spring_boot.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "members",
        uniqueConstraints = {
                @UniqueConstraint(name = "unq_login_id", columnNames = "login_id"),
                @UniqueConstraint(name = "unq_nickname", columnNames = "nickname")
        }
)
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String loginId;
    @Column(nullable = false)
    private String encryptedLoginPw;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @ManyToMany
    @JoinTable(
            name = "member_roles",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public Member() {
    }

    public Member(String loginId, String encryptedLoginPw, String nickname, Set<Role> roles) {
        this.loginId = loginId;
        this.encryptedLoginPw = encryptedLoginPw;
        this.nickname = nickname;
        this.roles = roles;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = OffsetDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getEncryptedLoginPw() {
        return encryptedLoginPw;
    }

    public String getNickname() {
        return nickname;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Member member)) return false;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
