package com.emergentes.dao;

import com.emergentes.ConexionBD;
import com.emergentes.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAOimpl extends ConexionBD implements UsuarioDAO{

    @Override
    public Usuario Validar(String usuario,String password) throws Exception {
        Usuario usu = new Usuario();
        try{
        String sql = "SELECT * FROM usuarios WHERE usuario = ? and password = ?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, password);
 
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            usu.setId(rs.getInt("id"));
            usu.setUsuario(rs.getString("usuario"));
            usu.setPassword(rs.getString("password"));
        }
        rs.close();
        ps.close();
        }catch(Exception ex){
            System.out.println("ERROR AL CONECTAR: "+ex.getMessage());
        }finally{
            this.Desconectar();
        }
        return usu;
    }
    
}
