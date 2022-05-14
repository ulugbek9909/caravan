package com.caravan.caravan.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "region")
@Getter
@Setter
public class RegionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nameUz")
    private String nameUz;

    @Column(name = "nameRu")
    private String nameRu;

    @Column(name = "nameEn")
    private String nameEn;

    @Column(name = "key")
    private String key;

}
