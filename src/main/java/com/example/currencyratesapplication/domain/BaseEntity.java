package com.example.currencyratesapplication.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "entity_seq")
    @SequenceGenerator(name = "entity_seq", sequenceName = "entity_seq",  allocationSize=1)
    private Long id;
}
