package br.com.a5.exerciciosjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import br.com.a5.exerciciosjava.util.CaminhosProperties;
import br.com.a5.exerciciosjava.util.LerArquivoProperties;

public class Conexao {

	public static Connection getConection() throws SQLException, Exception {

		LerArquivoProperties ler = new LerArquivoProperties();
		CaminhosProperties caminho = new CaminhosProperties();
		Properties prop = ler.getProp(caminho.propConexao);

		Connection con = null;

		try {

			String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String driver = prop.getProperty("drivername");
			String ip = prop.getProperty("ip");
			String porta = prop.getProperty("porta");
			String databaseName = prop.getProperty("databaseName");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");

			String connectionUrl = "jdbc:sqlserver://" + ip + ":" + porta + ";instanceName=" + databaseName
					+ ";databaseName=" + databaseName;
			Class.forName(driverName);
			con = DriverManager.getConnection(connectionUrl, user, password);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw e;
		}

		return con;
	}
}
