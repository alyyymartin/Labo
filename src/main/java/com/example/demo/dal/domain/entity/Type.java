package com.example.demo.dal.domain.entity;

import com.example.demo.dal.domain.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "types")
public class Type extends BaseEntity<Long> {

    @Getter
    @Setter
    @Column(name = "Types",unique = true, nullable = false, length = 50)
    private String type;

    @Getter
    @Setter
    @Column(name = "Description")
    private String description;

}

