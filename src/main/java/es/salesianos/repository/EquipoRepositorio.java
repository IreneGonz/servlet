package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.salesianos.model.Equipo;
import es.salesianos.model.Jugador;

@Component
public class EquipoRepositorio  extends AbstractRepository implements Repository<Equipo> {
	
	public void insert(Equipo equipoFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO EQUIPO (nombre)" + "VALUES (?)");
			preparedStatement.setString(1, equipoFormulario.getNombre());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	@Override
	public List<Equipo> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM EQUIPO");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Equipo equipo = new Equipo();
				equipo.setId(resultSet.getInt("id"));
				equipo.setNombre(resultSet.getString("nombre"));
				equipos.add(equipo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return equipos;
	}

	public Equipo listByEquipo(Integer idEquipo) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Equipo equipo;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM EQUIPO WHERE id=?");
			preparedStatement.setInt(1, idEquipo);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			equipo = new Equipo();
			equipo.setId(resultSet.getInt("id"));
			equipo.setNombre(resultSet.getString("nombre"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return equipo;
	}
	
	//Prueba para obtener el nombre a partir del id
	public String findNombreById(Integer id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		String nombre;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM EQUIPO WHERE id=?");
			preparedStatement.setString(1, String.valueOf(id));
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			nombre = resultSet.getString("nombre");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return nombre;
	}
	
	
	@Override
	public void update(Equipo equipo) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE EQUIPO SET nombre=? WHERE id=?");
			preparedStatement.setString(1, equipo.getNombre());
			preparedStatement.setInt(2, equipo.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}		
	}

	@Override
	public Equipo findBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
