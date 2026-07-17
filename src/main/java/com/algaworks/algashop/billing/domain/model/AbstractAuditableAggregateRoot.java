package com.algaworks.algashop.billing.domain.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)    // Hibernate consegue trabalhar a nivel de atributos, sem precisar dos setters
@MappedSuperclass               // Todos que extenderem desta classe, ficarão com as propriedades do Jakarta Persistence e do Spring Data
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableAggregateRoot<T extends AbstractAggregateRoot<T>>
        extends AbstractAggregateRoot<T> {

    @CreatedBy
    protected UUID createdByUserId;

    @CreatedDate
    protected OffsetDateTime createdAt;

    @LastModifiedBy
    protected UUID lastModifiedByUserId;

    @LastModifiedDate
    protected OffsetDateTime lastModifiedDate;

    @Version
    protected long version;
}
