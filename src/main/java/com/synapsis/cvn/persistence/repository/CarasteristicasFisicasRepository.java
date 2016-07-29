package com.synapsis.cvn.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.synapsis.cvn.persistence.entity.CaracteristicasFisicas;

@Repository
public interface CarasteristicasFisicasRepository extends PagingAndSortingRepository<CaracteristicasFisicas, Long>{

}
