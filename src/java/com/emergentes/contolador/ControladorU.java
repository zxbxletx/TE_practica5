package com.emergentes.contolador;

import com.emergentes.dao.UsuarioDAO;
import com.emergentes.dao.UsuarioDAOimpl;
import com.emergentes.modelo.Usuario;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorU", urlPatterns = {"/ControladorU"})
public class ControladorU extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("usu");            
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
         
        UsuarioDAO userDao = new UsuarioDAOimpl();
         
        try {
            Usuario usu = userDao.Validar(usuario, password);
            String destPage = "Login.jsp";
            if (usu.getUsuario()!=null && usu.getPassword()!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("usu", usu);
                destPage = "Bienvenida.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            } 
            request.getRequestDispatcher(destPage).forward(request, response);
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR :   "+ex.getMessage());
        }
    }
}
