package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

	public static Connection getConexao() {
		Connection conexao = null;
		
		try {
			Properties prop = getProperties();
			final String url = prop.getProperty("banco.url");
			final String usuario = prop.getProperty("banco.usuario");
			final String senha = prop.getProperty("banco.senha");
			
			conexao = DriverManager.getConnection(url, usuario, senha);
			
		} catch (SQLException | IOException erro) {
			throw new RuntimeException(erro);
		}
		
		
		return conexao;		
	}
	
	private static Properties getProperties( ) throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao.properties";
		
		prop.load(Conexao.class.getResourceAsStream(caminho));
		return prop;
	}
}
