package com.switchone.payment.domain;


import com.switchone.payment.enums.Currency;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_user_point")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString
public class UserPoint extends AbstractTimestampEntity<Long> {

    private static final long serialVersionUID = -4313306939943237518L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_id")
    private Long id;

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "balance")
    private Long balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;

//    @OneToMany(mappedBy = "userPoint", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
//    @ToString.Exclude
//    private Set<UserDeposit> userDeposits;
}
