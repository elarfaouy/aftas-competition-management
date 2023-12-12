package com.youcode.aftas.service;

import com.youcode.aftas.web.dto.read.MemberDto;
import com.youcode.aftas.web.dto.store.StoreMemberDto;
import org.springframework.stereotype.Service;

@Service
public interface IMemberService {
    MemberDto store(StoreMemberDto storeMemberDto);
}
