package com.apiufpso.tienda.repository;

import com.apiufpso.tienda.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
