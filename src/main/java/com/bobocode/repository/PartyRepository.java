package com.bobocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bobocode.entity.PartyMember;

public interface PartyRepository extends JpaRepository<PartyMember, Long> {
}
