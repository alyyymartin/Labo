package com.example.demo.dal.domain.entity.base;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> extends AuditedEntity {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    protected T id;
}
