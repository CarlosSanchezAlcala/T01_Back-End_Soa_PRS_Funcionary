package com.soa.canete.funcionary_soa_canete.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "funcionary")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionary {

    @Id
    private Integer id_funcionary;
    @Column
    private String name;
    @Column
    private String surnamefather;
    @Column
    private String surnamemother;
    @Column
    private String dni;
    @Column
    private String phonenumber;
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
    @Column
    private String status;

    public Funcionary(String name, String surnamefather, String surnamemother, String dni, String phonenumber, String range, String confirmation, String address, String email, String codubi, String status) {
        this.name = name;
        this.surnamefather = surnamefather;
        this.surnamemother = surnamemother;
        this.dni = dni;
        this.phonenumber = phonenumber;
        this.range = range;
        this.confirmation = confirmation;
        this.address = address;
        this.email = email;
        this.codubi = codubi;
        this.status = status;
    }
}
