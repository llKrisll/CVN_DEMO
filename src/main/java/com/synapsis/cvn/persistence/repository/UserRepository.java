package com.synapsis.cvn.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.synapsis.cvn.persistence.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);

}
