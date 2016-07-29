package com.synapsis.cvn.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.synapsis.cvn.persistence.entity.TipoDocumentoIdentidad;

@Repository
public interface TipoDocumentoIdentidadRepository extends PagingAndSortingRepository<TipoDocumentoIdentidad, Long> {
	
}
