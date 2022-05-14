package com.caravan.caravan.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "attach")
@Getter
@Setter
public class AttachEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String originalName;

    @Column
    private Long size;

    @Column
    private String path;

    @Column
    private String extension;

    @Column
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

}
