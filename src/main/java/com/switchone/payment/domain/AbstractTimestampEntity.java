package com.switchone.payment.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractTimestampEntity<K extends Serializable> extends AbstractEntity<K> {
    private static final long serialVersionUID = 9003844949075268991L;

    @Column(name = "created_dt", updatable = false)
    @CreatedDate
    private LocalDateTime createdDt;

    @Column(name = "updated_dt")
    @LastModifiedDate
    private LocalDateTime updatedDt;

}
