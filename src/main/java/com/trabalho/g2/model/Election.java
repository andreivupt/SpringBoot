package com.trabalho.g2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tb_election")
public class Election implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer year;

    @Column(nullable = false)
    private String stateCode;

    @Column
    private String description;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
