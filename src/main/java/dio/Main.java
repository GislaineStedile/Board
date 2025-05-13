package dio;


import dio.persistence.migration.MigrationStrategy;
import dio.ui.MainMenu;

import java.sql.Connection;
import java.sql.SQLException;

import static dio.persistence.config.ConnectionConfig.getConnection;

public class Main {

	public static void main(String[] args) throws SQLException {
		try(Connection connection = getConnection()){
			new MigrationStrategy(connection).executeMigration();
		}
		new MainMenu().execute();

		/*try(Connection connection = ConnectionConfig.getConnection()){
			if (connection != null) {
				System.out.println("Conexão bem-sucedida!");
			} else {
				System.err.println("Falha ao conectar ao banco de dados.");
			}
		}catch (SQLException ex){
			System.out.println("Erro");
		}*/
	}

}
