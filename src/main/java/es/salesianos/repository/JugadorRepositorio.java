package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.salesianos.model.Jugador;

@Component
public class JugadorRepositorio extends AbstractRepository implements Repository<Jugador> {

	public void insert(Jugador jugadorFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO JUGADOR (nombre,apellido,codEquipo)" + "VALUES (?, ?, ?)");
			preparedStatement.setString(1, jugadorFormulario.getNombre());
			preparedStatement.setString(2, jugadorFormulario.getApellido());
			preparedStatement.setString(3, String.valueOf(jugadorFormulario.getCodEquipo()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<Jugador> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM JUGADOR");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Jugador jugador = new Jugador();
				jugador.setId(resultSet.getInt("id"));
				jugador.setNombre(resultSet.getString("nombre"));
				jugador.setApellido(resultSet.getString("apellido"));
				jugador.setCodEquipo(Integer.parseInt(resultSet.getString("codEquipo")));
				jugadores.add(jugador);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return jugadores;

	}

	public Jugador listByJugador(Integer idJugador) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Jugador jugador;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM JUGADOR WHERE id=?");
			preparedStatement.setInt(1, idJugador);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			jugador = new Jugador();
			jugador.setId(resultSet.getInt("id"));
			jugador.setNombre(resultSet.getString("nombre"));
			jugador.setApellido(resultSet.getString("apellido"));
			jugador.setCodEquipo(Integer.parseInt(resultSet.getString("codEquipo")));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return jugador;
	}

	public void update(Jugador jugador) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE JUGADOR SET nombre=? , apellido=? , codEquipo=? WHERE id=?");
			preparedStatement.setString(1, jugador.getNombre());
			preparedStatement.setString(2, jugador.getApellido());
			preparedStatement.setInt(3, jugador.getCodEquipo());
			preparedStatement.setInt(4, jugador.getId());
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
	public Jugador findBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
