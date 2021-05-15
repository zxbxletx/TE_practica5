<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORM</title>
    </head>
    <body>
            <h1 ALIGN="center">
                <c:if test="${post.id == 0}">Nuevo </c:if>
                <c:if test="${post.id != 0}">Editar </c:if>
                    Post
                </h1>
                <form action="Controlador" method="post">
                    <input type="hidden" name="id" value="${post.id}">
                <table ALIGN="center">
                    <tr>
                        <td>FECHA:   </td>
                        <td><input type="date" name="fecha" value="${post.fecha}" required></td>
                    </tr>
                    <tr>
                        <td>TITULO:  </td>
                        <td><input type="text" name="titulo" value="${post.titulo}" required></td>
                    </tr>
                    <tr>
                        <td>CONTENIDO:  </td>
                        <td><textarea name="contenido" rows="10" cols="40" required>${post.contenido}</textarea></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="ENVIAR"></td>
                        <td></td>
                        <td><a href="Controlador">CANCELAR</a> </td>
                    </tr>
                </table>
            </form>
    </body>
</html>
