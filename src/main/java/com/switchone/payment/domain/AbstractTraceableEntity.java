package com.switchone.payment.domain;

import com.switchone.payment.constants.ColumnSizeConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractTraceableEntity<K extends Serializable> extends AbstractEntity<K> {
    private static final long serialVersionUID = -7001005364484290431L;

    @Column(name = "created_dt", updatable = false)
    @CreatedDate
    protected LocalDateTime createdDt;

    @Column(name = "created_by", updatable = false, length = ColumnSizeConstants.UUID)
    @CreatedBy
    protected String createdBy;

    @Column(name = "created_by_nm", updatable = false, length = ColumnSizeConstants.FULL_NAME)
    protected String createdByNm;

    @Column(name = "updated_dt")
    @LastModifiedDate
    protected LocalDateTime updatedDt;

    @Column(name = "updated_by", length = ColumnSizeConstants.UUID)
    @LastModifiedBy
    protected String updatedBy;

    @Column(name = "updated_by_nm", length = ColumnSizeConstants.FULL_NAME)
    protected String updatedByNm;
}