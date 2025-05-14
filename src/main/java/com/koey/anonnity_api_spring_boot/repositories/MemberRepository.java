package com.koey.anonnity_api_spring_boot.repositories;

import com.koey.anonnity_api_spring_boot.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
