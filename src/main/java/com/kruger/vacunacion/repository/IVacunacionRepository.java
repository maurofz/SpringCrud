package com.jhonny.vacunacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jhonny.vacunacion.entity.Vacunacion;

public interface IVacunacionRepository extends JpaRepository<Vacunacion, Integer>{
	
	@Query(value="SELECT T_EMPLEADO.*,T_PERSONA.*,T_VACUNACION.* FROM T_VACUNACION INNER JOIN T_EMPLEADO ON T_EMPLEADO.empleado_id=T_VACUNACION.id_empleado INNER JOIN T_PERSONA ON T_VACUNACION.id_empleado=T_PERSONA.id AND T_VACUNACION.tipo_vacuna=:vacuna",nativeQuery = true)
	List<?> findByVacuna(@Param("vacuna") String vacuna);
}
