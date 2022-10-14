package com.bobocode.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.bobocode.model.PartyMember;

@Service
public class PartyService {

    private static final Set<PartyMember> partyMembers = ConcurrentHashMap.newKeySet();


    public String goToParty(PartyMember partyMember) {
        partyMembers.add(partyMember);
        return String.format("%s %s is partying!", partyMember.firstName(), partyMember.lastName());
    }

    public List<PartyMember> listAllMembers() {
        return partyMembers.stream().toList();
    }
}
