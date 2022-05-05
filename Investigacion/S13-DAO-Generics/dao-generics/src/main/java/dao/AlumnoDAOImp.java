package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Alumno;

public class AlumnoDAOImp extends GenericoDAO<Alumno, Integer> implements AlumnoDAO{

	public AlumnoDAOImp() {
		//nombre de la tabla
		super("alumnosact");
	}
	
	@Override
	public List<Alumno> findByCarrera(int carreraId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno makeObjectEntity(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String nombre = rs.getString("nombre");
		return new Alumno(id, nombre);
	}
	
	

}
