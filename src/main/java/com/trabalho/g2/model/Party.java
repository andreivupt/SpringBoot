package com.trabalho.g2.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity(name = "tb_party")
public class Party implements Serializable {


    @Id
    @SequenceGenerator(name = "party_id", sequenceName = "party_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_id")
    private String code;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "Nome é uma informação obrigatória.")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Number é uma informação obrigatória.")
    private Integer number;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
