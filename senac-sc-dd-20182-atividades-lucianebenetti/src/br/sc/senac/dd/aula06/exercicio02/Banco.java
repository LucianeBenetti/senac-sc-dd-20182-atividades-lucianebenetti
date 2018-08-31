package br.sc.senac.dd.aula06.exercicio02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
	private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private static final String NOME_ESQUEMA = "dbsupermercado";
	private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/" + NOME_ESQUEMA;
	private static final String USUARIO = "root";
	private static final String SENHA = "";

	/**
	 * Estabelece a conex�o JBDC considerando as configura��es da classe Banco.
	 * @return Connection um objeto de conex�o JDBC.
	 * @throws ClassNotFoundException
	 * caso o nome completo de DRIVER_MYSQL esteja incorreto ou o driver JDBC do banco selecionado n�o foi adicionado ao
	 * projeto (via .jar ou depend�ncia no pom.xml).
	 * @throws SQLException
	 * caso a URL_CONEXAO, USUARIO e/ou SENHA estejam incorretos.
	 */

	public static Connection getConnection() {
		try {
			Connection conn = null;
			Class.forName(DRIVER_MYSQL);
			conn = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("Classe do Driver n�o foi encontrada. \n" + e.getMessage());
			return null;
		} catch (SQLException e) {
			System.out.println("Erro ao obter a Connection.\n" + e.getMessage());
			return null;
		}
	}

	/**
	 * Fecha uma conex�o informada pelo chamador.
	 * @param conn o objeto do tipo Connection que deve ser fechado
	 */

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento da conex�o.");
		}
	}

	/**
	 * Solicita um objeto Statement para uma conex�o. Este objeto serve para executar as opera��es SQL.
	 * Este m�todo deve ser sempre chamado nos DAOs ap�s a cria��o da express�o SQL, geralmente com os m�todos execute(sql), 
	 * executeUpdate(sql) ou executeQuery(sql), onde "sql" � do tipo String.
	 * @param conn uma conex�o anteriormente criada.
	 * @return stmt um objeto do tipo Statement
	 * @throws SQLException
	 */

	public static Statement getStatement(Connection conn) {
		try {
			Statement stmt = conn.createStatement();
			return stmt;
		} catch (SQLException e) {
			System.out.println("Erro ao obter o Statement.");
			return null;
		}
	}

	/**
	 * Fecha um objeto Statement anteriormente criado.
	 * Este m�todo deve ser sempre chamado nos DAOs ap�s a execu��o da express�o SQL.
	 * @param stmt um objeto do tipo Statement
	 * @throws SQLException
	 */

	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do Statement.");
		}
	}

	/**
	 * 
	 * Solicita um objeto PreparedStatement para uma conex�o. Este objeto serve para executar as opera��es SQL.
	 * @param conn uma conex�o anteriormente criada.
	 * @return stmt um objeto do tipo PreparedStatement
	 * @throws SQLException
	 */

	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	public static PreparedStatement getPreparedStatement(Connection conn, String sql, int tipoRetorno) {
		try {
			PreparedStatement stmt = conn.prepareStatement(sql, tipoRetorno);
			return stmt;
		} catch (Exception e) {
			System.out.println("Erro ao obter o PreparedStatement.");
			return null;
		}
	}

	/**
	 * Fecha um objeto PreparedStatement anteriormente criado.
	 * Este m�todo deve ser sempre chamado nos DAOs ap�s a execu��o da express�o SQL.
	 * @param stmt um objeto do tipo PreparedStatement
	 * @throws SQLException
	 */

	public static void closePreparedStatement(PreparedStatement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do PreparedStatement.");
		}
	}

	/**
	 * Fecha um objeto ResultSet anteriormente criado.
	 * Este m�todo deve ser sempre chamado nos DAOs ap�s a consulta de todos os
	 * resultados e convers�o para objetos.
	 * @param result um objeto do tipo ResultSet
	 * @throws SQLException
	 */

	public static void closeResultSet(ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			System.out.println("Problema no fechamento do ResultSet");
		}
	}
}