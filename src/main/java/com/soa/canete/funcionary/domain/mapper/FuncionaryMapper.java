package com.soa.canete.funcionary.domain.mapper;

import com.soa.canete.funcionary.domain.dto.FuncionaryRequestDto;
import com.soa.canete.funcionary.domain.dto.FuncionaryResponseDto;
import com.soa.canete.funcionary.domain.model.Funcionary;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FuncionaryMapper {

    public static Funcionary toModel(FuncionaryRequestDto dto) {
        return new Funcionary(
                dto.getName(),
                dto.getSurnameFather(),
                dto.getSurnameMother(),
                dto.getDni(),
                dto.getPhoneNumber(),
                dto.getRange(),
                dto.getConfirmation(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getCodubi(),
                dto.getIdOperativeUnit(),
                dto.getStatus()
        );
    }

    public static Funcionary toModel(FuncionaryRequestDto dto, Integer id_funcionary) {
        return new Funcionary(
                id_funcionary,
                dto.getName(),
                dto.getSurnameFather(),
                dto.getSurnameMother(),
                dto.getDni(),
                dto.getPhoneNumber(),
                dto.getRange(),
                dto.getConfirmation(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getCodubi(),
                dto.getIdOperativeUnit(),
                dto.getStatus()
        );
    }

    public static FuncionaryResponseDto toDto(Funcionary model) {
        return new FuncionaryResponseDto(
                model.getId_funcionary(),
                model.getName(),
                model.getSurnameFather(),
                model.getSurnameMother(),
                model.getDni(),
                model.getPhoneNumber(),
                model.getRange(),
                model.getConfirmation(),
                model.getAddress(),
                model.getEmail(),
                model.getCodubi(),
                model.getIdOperativeUnit(),
                model.getStatus()
        );
    }

}
