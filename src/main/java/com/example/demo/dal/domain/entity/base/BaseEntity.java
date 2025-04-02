package com.example.demo.dal.domain.entity.base;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
@Data
public abstract class BaseEntity<T extends Serializable>  {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    protected T id;

    private boolean active = true;
}
