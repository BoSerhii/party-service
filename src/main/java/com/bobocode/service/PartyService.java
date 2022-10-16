package com.bobocode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bobocode.entity.PartyMember;
import com.bobocode.repository.PartyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PartyService {

    private PartyRepository repository;

    public void goToParty(PartyMember partyMember) {
        repository.save(partyMember);
    }

    public List<PartyMember> listAllMembers() {
        return repository.findAll();
    }
}
