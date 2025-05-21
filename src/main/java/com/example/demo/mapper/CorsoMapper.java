package com.example.demo.mapper;


import com.example.demo.data.dto.CorsoDTO;
import com.example.demo.data.entity.Corso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CorsoMapper {
    CorsoDTO toDto(Corso corso);
    Corso toEntity(CorsoDTO dto);
}
