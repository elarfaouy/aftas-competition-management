package com.youcode.aftas.service;

import com.youcode.aftas.web.dto.read.MemberDto;
import com.youcode.aftas.web.dto.store.StoreMemberDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMemberService {
    List<MemberDto> findAll();
    MemberDto store(StoreMemberDto storeMemberDto);
}
