package com.youcode.aftas.service.imp;

import com.youcode.aftas.domain.entity.Competition;
import com.youcode.aftas.exception.LogicValidationException;
import com.youcode.aftas.web.dto.store.StoreCompetitionDto;
import org.modelmapper.ModelMapper;
import com.youcode.aftas.repository.CompetitionRepository;
import com.youcode.aftas.service.ICompetitionService;
import com.youcode.aftas.web.dto.read.CompetitionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompetitionService implements ICompetitionService {
    private final CompetitionRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<CompetitionDto> findAll() {
        return repository
                .findAll()
                .stream()
                .map((element) -> mapper.map(element, CompetitionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompetitionDto store(StoreCompetitionDto storeCompetitionDto) {

        if (!codeMatchFormattedCode(storeCompetitionDto.getCode(), storeCompetitionDto.getLocation(), storeCompetitionDto.getDate())) {
            throw new LogicValidationException("invalid code value, code must be like ex: imsouane: pattern: ims-22-12-23.");
        }

        if (!storeCompetitionDto.getEndTime().isAfter(storeCompetitionDto.getStartTime())) {
            throw new LogicValidationException("invalid time, end time must be after start.");
        }

        if (!(Duration.between(storeCompetitionDto.getStartTime(), storeCompetitionDto.getEndTime()).toHours() > 2)) {
            throw new LogicValidationException("invalid time, duration must be greater than 2 hours.");
        }

        if (repository.existsByDate(storeCompetitionDto.getDate())) {
            throw new LogicValidationException("invalid date, its allowed only one competition in a day.");
        }

        Competition competition = mapper.map(storeCompetitionDto, Competition.class);
        Competition saved = repository.save(competition);
        return mapper.map(saved, CompetitionDto.class);
    }

    private Boolean codeMatchFormattedCode(String code, String location, LocalDate date) {
        String formattedLocation = location.substring(0, Math.min(3, location.length()));
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yy"));

        String formattedCode = formattedLocation + "-" + formattedDate;
        return code.equals(formattedCode);
    }
}
