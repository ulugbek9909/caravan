package com.caravan.caravan.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class AttachEntity  {
    @Id
    private String id;
    @Column
    private String originName;
    @Column
    private Long size;
    @Column
    private String path;
    @Column
    private String extention;
    @Column
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

}
