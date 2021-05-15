
package com.emergentes.dao;

import com.emergentes.modelo.Usuario;

public interface UsuarioDAO {

    public Usuario Validar(String usuario,String password) throws Exception;
    
}
