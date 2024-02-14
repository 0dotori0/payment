package com.switchone.payment.domain;

import com.switchone.payment.constants.ColumnSizeConstants;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "tb_user")
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString
public class User extends AbstractTraceableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", length = ColumnSizeConstants.NAME)
    private String name;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @ToString.Exclude
//    @NotAudited
    private Set<UserPaymentOrder> userPaymentOrders = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private UserPoint userPoint;

//    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
//    @ToString.Exclude
////    @NotAudited
//    private Set<UserDeposit> userDeposits = new HashSet<>();
}
