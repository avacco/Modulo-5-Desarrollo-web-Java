package dao;

import java.util.List;

import modelo.Alumno;

public interface AlumnoDAO extends BaseDAO<Alumno, Integer> {
	
	List<Alumno> findByCarrera(int carreraId);
	
	

}
