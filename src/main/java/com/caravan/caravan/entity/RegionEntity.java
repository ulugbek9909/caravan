package com.caravan.caravan.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "region")
@Entity
@Data
public class RegionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;


    @Column(name = "nameUz")
    private String nameUz;
    @Column(name = "nameRu")
    private String nameRu;
    @Column(name = "nameEn")
    private String nameEn;
    @Column(name = "key")
    private String key;

}
