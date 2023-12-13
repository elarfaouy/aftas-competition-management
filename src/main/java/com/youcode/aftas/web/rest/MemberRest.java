package com.youcode.aftas.web.rest;

import com.youcode.aftas.service.IMemberService;
import com.youcode.aftas.web.dto.read.MemberDto;
import com.youcode.aftas.web.dto.store.StoreMemberDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberRest {
    @Qualifier("memberService")
    private final IMemberService service;

    @PostMapping
    public MemberDto save(@Valid @RequestBody StoreMemberDto storeMemberDto){
        return service.store(storeMemberDto);
    }
}
