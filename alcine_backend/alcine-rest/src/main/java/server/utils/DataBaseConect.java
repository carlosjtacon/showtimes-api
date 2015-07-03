package server.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConect {

	private static Connection c = null;
    private static Statement s = null;
    private static ResultSet rs = null;
    
    public DataBaseConect(){
    	DataBaseConect.cargarDriver();
    }
      
    public static void cargarDriver(){
    	try {	
    		Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    public static void conectarAlServidor(String usuario, String pass, String host, String nombredb){          
	    try {
	    	c = DriverManager.getConnection("jdbc:postgresql://" + host + ":5432/" + nombredb + "?user=" + usuario + "&password=" + pass);
	    } catch (SQLException se) {
		      se.printStackTrace();
	    }
    }
    
    public static ResultSet exeQuery(String query)
    {
    	try {
            s = c.createStatement();
    	} catch (SQLException se) {
            se.printStackTrace();
            System.out.println("Consulta:" + query);
    	}
    	try {
			rs=s.executeQuery(query);
    	} catch (SQLException se) {
	        se.printStackTrace();
            System.out.println("Consulta:" + query);
		}
    	return rs;
    }
    
    public static int exeUpdate(String query)
    {
    	int result = 0;
    	
    	try {
            s = c.createStatement();
    	} catch (SQLException se) {
            se.printStackTrace();
            System.out.println("Consulta:" + query);
    	}
    	
    	try {
			result = s.executeUpdate(query);
    	} catch (SQLException se) {
	        se.printStackTrace();
	        System.out.println("Consulta:" + query);
		}
    	
    	return result;
    }
    
	public static void cerrarConexion() throws SQLException {
		if(rs != null) {
			rs.close();
		}
	    s.close();
	    c.close();	    	
	}
	
}
