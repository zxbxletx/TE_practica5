package com.emergentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    private String url="jdbc:mysql://localhost:3306/bd_blog";
    private String usuario="root";
    private String password="";
    
    protected Connection conn=null;

    public ConexionBD(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if(conn != null){
                System.out.println("CONEXION OK :   " + conn);
            }
        }catch(SQLException e){
            System.out.println("ERROR DE SQL :  " + e.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("FALTA DRIVER:_  " +ex.getMessage());
        }
    }
    
    public Connection Conectar(){
        return conn;
    }
    
    public void Desconectar(){
        System.out.println("Cerrando la BASE de DATOS:  "+conn);
        try{
            conn.close();
        }catch(Exception e){
            System.out.println("ERROR DE SQL:   "+e.getMessage());
        }
    }
    
}
