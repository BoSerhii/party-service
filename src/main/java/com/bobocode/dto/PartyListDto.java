package com.bobocode.dto;

import java.util.List;


public record PartyListDto(long size, List<PartyMemberDto> partyMembers) {}
