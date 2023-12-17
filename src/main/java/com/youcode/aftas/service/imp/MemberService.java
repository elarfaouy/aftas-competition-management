package com.youcode.aftas.service.imp;

import com.youcode.aftas.domain.entity.Member;
import com.youcode.aftas.exception.DataBaseConstraintException;
import com.youcode.aftas.repository.MemberRepository;
import com.youcode.aftas.service.IMemberService;
import com.youcode.aftas.web.dto.read.MemberDto;
import com.youcode.aftas.web.dto.store.StoreMemberDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MemberService implements IMemberService {
    private final MemberRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<MemberDto> findAll() {
        return repository
                .findAll()
                .stream().map((element) -> mapper.map(element, MemberDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MemberDto store(StoreMemberDto storeMemberDto) {
        Optional<Member> optional = repository.findById(storeMemberDto.getNum());
        if (optional.isPresent()) {
            throw new DataBaseConstraintException("already register member with same number.");
        }

        try {
            Member member = mapper.map(storeMemberDto, Member.class);
            member.setAccessionDate(LocalDate.now());
            Member saved = repository.save(member);
            return mapper.map(saved, MemberDto.class);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseConstraintException("error when save member, identity number must be unique");
        }
    }
}
