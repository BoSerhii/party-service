package com.bobocode.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobocode.model.PartyList;
import com.bobocode.model.PartyMember;
import com.bobocode.service.PartyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/party")
@AllArgsConstructor
public class PartyController {

    public PartyService partyService;

    @GetMapping
    public ResponseEntity<PartyList> getAll() {
        var partyMembers = partyService.listAllMembers();
        return new ResponseEntity<>(new PartyList(partyMembers.size(), partyMembers), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> goToParty(@RequestBody PartyMember partyMember) {
        return new ResponseEntity<>(partyService.goToParty(partyMember), HttpStatus.ACCEPTED);
    }
}
