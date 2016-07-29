package com.synapsis.cvn.persistence.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synapsis.cvn.persistence.entity.Persona;
import com.synapsis.cvn.persistence.entity.TipoDocumentoIdentidad;

@Repository
public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long> {
	
	Persona findByNumeroDocumentoIdentidad(String NumeroDocumentoIdentidad);

//    @Query("SELECT p FROM Persona p where p.apellidoPaterno like '%:apellidoPaterno%' ") 
	List<Persona> findByNombresContainingIgnoreCase(String nombres);
	
	List<Persona> findByApellidoPaternoContainingIgnoreCase(String apellidoPaterno);
	
	List<Persona> findByApellidoMaternoContainingIgnoreCase(String apellidoMaterno);
	
	List<Persona> findByFechaNacimiento(Date fechaNacimiento);
	
	@Modifying
	@Transactional
	@Query("update Persona p set p.nombres = :nombres, p.apellidoPaterno = :apellidoPaterno, "
	    + "p.apellidoMaterno = :apellidoMaterno, p.numeroDocumentoIdentidad = :numeroDocumentoIdentidad, "
	    + "p.tipoDocumentoIdentidad = :tipoDocumentoIdentidad, "
	    + "p.sexo = :sexo "
	    + "where p.id = :id")
	int actualizarPersona(
	        @Param("nombres") String nombres, 
		    @Param("apellidoPaterno") String apellidoPaterno,
		    @Param("apellidoMaterno") String apellidoMaterno,
		    @Param("tipoDocumentoIdentidad") TipoDocumentoIdentidad tipoDocumentoIdentidad,
		    @Param("sexo") String sexo,
		    @Param("id") String id);
	
	@Modifying
	@Transactional
	@Query("update Persona p set p.activo = :activo"
	    + " where p.id = :id")
	int activarPersona(
	        @Param("activo") boolean activo, 
		    @Param("id") Long id);
	
	
	
//	@Modifying
//	@Transactional
//	@Query("update User u set u.lastLogin = CURRENT_TIMESTAMP where u.userName = ?1")
//	int updateLastLogin(String userName);
//	
//	@Modifying
//	@Transactional
//	@Query("update User u set u.profilePicture = ?2 where u.userName = ?1")
//	int updateProfilePicture(String userName, String profilePicture);
}
