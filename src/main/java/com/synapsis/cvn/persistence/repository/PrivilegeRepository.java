package com.synapsis.cvn.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.synapsis.cvn.persistence.entity.Privilege;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

    Privilege findByName(String name);

    @Override
    void delete(Privilege privilege);

}
