package com.youcode.aftas.web.rest;

import com.youcode.aftas.dto.payload.MemberDto;
import com.youcode.aftas.dto.store.StoreMemberDto;
import com.youcode.aftas.service.IMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberRest {
    private final IMemberService memberService;

    @GetMapping
    public List<MemberDto> getAll() {
        return memberService.findAll();
    }

    @PostMapping
    public MemberDto save(@Valid @RequestBody StoreMemberDto storeMemberDto) {
        return memberService.store(storeMemberDto);
    }
}
