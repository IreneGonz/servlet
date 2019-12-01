package es.salesianos.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nomEquipo = req.getParameter("nomEquipo");
		String idEquipo = req.getParameter("idEquipo");
		
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		System.out.println(name + " " + surname);
		Connection conn;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(jdbcUrl, "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2 = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM JUGADOR WHERE nombre = ? and apellido = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			preparedStatement.executeUpdate();
						
			
			preparedStatement2 = conn.prepareStatement("DELETE FROM JUGADOR WHERE codEquipo = ?");
			preparedStatement2.setString(1, idEquipo);
			preparedStatement2.executeUpdate();
			
			preparedStatement = conn.prepareStatement("DELETE FROM EQUIPO WHERE id = ? AND nombre = ?");
			preparedStatement.setString(1, idEquipo);
			preparedStatement.setString(2, nomEquipo);
			preparedStatement.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		redirect(req, resp, "Listado.jsp");
	}
	
	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}
