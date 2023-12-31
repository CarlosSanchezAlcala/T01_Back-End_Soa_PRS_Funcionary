package com.soa.canete.funcionary.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class FuncionaryRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 8222253670338491507L;

    @Column
    private String name;
    @Column("surnamefather")
    private String surnameFather;
    @Column("surnamemother")
    private String surnameMother;
    @Column
    private String dni;
    @Column("phonenumber")
    private String phoneNumber;
    @Column
    private String range;
    @Column
    private String confirmation;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String codubi;
    @Column("id_operativeunit")
    private Integer idOperativeUnit;
    @Column
    private String status;
}
