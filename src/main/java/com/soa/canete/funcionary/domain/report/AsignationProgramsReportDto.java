package com.soa.canete.funcionary.domain.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
