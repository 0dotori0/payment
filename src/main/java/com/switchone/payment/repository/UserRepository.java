package com.switchone.payment.repository;

import com.switchone.payment.domain.User;

public interface UserRepository extends GenericRepository<User, Long>, UserRepositoryCustom {
}
