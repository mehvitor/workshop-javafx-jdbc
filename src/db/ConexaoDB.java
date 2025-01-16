package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConexaoDB 	{
	
	private static final String URL = "jdbc:postgresql://localhost:5432/coursejavafx";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "9qtfoaoc";

    private static Connection conexao;
    
    public static Connection getConexao() {
        try {	
            if(conexao == null) {
            	Class.forName("org.postgresql.Driver");
            	conexao = DriverManager.getConnection(URL, USUARIO, SENHA);  
            
            }
            return conexao;
            
        } catch (ClassNotFoundException e ) {
        	JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o driver de acesso");
        	return null;
        
        } catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
   
    }
    
    public static void closeConexao() {
    	if(conexao != null) {
    		try	{
    			conexao.close();
    		}
    		catch (SQLException e) {
    			throw new DbException(e.getMessage());
    		}
    	}
    }
    
    public static void closeStatement(Statement st) {
    	if(st != null) {
    		try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
    	}
    }

    public static void closeResultSet(ResultSet rs)  {
    	if(rs != null) {
    		try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
    	}
    }
}