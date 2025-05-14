package com.koey.anonnity_api_spring_boot.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "member_roles")
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
}
