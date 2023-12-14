package com.soa.canete.funcionary_soa_canete.domain.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignationProgramsReportDto {

    private Integer id_funcionary;
    private String name;
    private String surnameFather;
    private String surnameMother;
    private String dni;
    private String range;
    private Integer soa;
}
