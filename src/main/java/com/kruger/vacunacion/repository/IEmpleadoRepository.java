package com.jhonny.vacunacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jhonny.vacunacion.entity.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
	@Query(value="SELECT T_EMPLEADO.*,T_PERSONA.* FROM T_EMPLEADO INNER JOIN T_PERSONA ON T_EMPLEADO.empleado_id=T_PERSONA.id AND T_EMPLEADO.estado=:estado",nativeQuery = true)
	List<?> findByEstado(@Param("estado") boolean estado);
	
	@Query(value="SELECT T_EMPLEADO.*,T_PERSONA.*,T_VACUNACION.* FROM T_VACUNACION INNER JOIN T_EMPLEADO ON T_EMPLEADO.empleado_id=T_VACUNACION.id_empleado INNER JOIN T_PERSONA ON T_VACUNACION.id_empleado=T_PERSONA.id AND T_VACUNACION.tipo_vacuna=:vacuna",nativeQuery = true)
	List<?> findByVacuna(@Param("vacuna") String vacuna);
}
