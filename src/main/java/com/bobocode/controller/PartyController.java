package com.bobocode.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobocode.dto.PartyListDto;
import com.bobocode.dto.PartyMemberDto;
import com.bobocode.entity.PartyMember;
import com.bobocode.service.PartyService;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/party")
@AllArgsConstructor
@Slf4j
public class PartyController {

    private PartyService partyService;
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<PartyListDto> getAll() {
        var partyMemberDtoList = partyService.listAllMembers().stream()
            .map(member -> mapper.map(member, PartyMemberDto.class)).toList();
        return new ResponseEntity<>(new PartyListDto(partyMemberDtoList.size(), partyMemberDtoList), HttpStatus.OK);
    }


    @PostMapping
    @SneakyThrows
    public ResponseEntity<Void> goToParty(@RequestBody PartyMemberDto partyMember) {
        partyService.goToParty(mapper.map(partyMember, PartyMember.class));
        log.debug(String.format("%s has attended party!", partyMember.toString()));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
