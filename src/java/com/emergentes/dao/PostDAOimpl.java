package com.emergentes.dao;

import com.emergentes.ConexionBD;
import com.emergentes.modelo.Post;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PostDAOimpl extends ConexionBD implements PostDAO{

    @Override
    public void insert(Post post) throws Exception {
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("insert into posts(fecha,titulo,contenido) values(?,?,?)");
            ps.setString(1, post.getFecha());
            ps.setString(2, post.getTitulo());
            ps.setString(3, post.getContenido());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public void update(Post post) throws Exception {
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("update posts set fecha=?, titulo=?, contenido=? where id=?");
            ps.setString(1, post.getFecha());
            ps.setString(2, post.getTitulo());
            ps.setString(3, post.getContenido());
            ps.setInt(4, post.getId());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("delete from posts where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public Post getById(int id) throws Exception {
        Post pos=new Post();
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("select *from posts where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pos.setId(rs.getInt("id"));
                pos.setFecha(rs.getString("fecha"));
                pos.setTitulo(rs.getString("titulo"));
                pos.setContenido(rs.getString("contenido"));
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
        return pos;
    }

    @Override
    public List<Post> getAll() throws Exception {
        List<Post> lista= null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("select *from posts order by fecha desc");
            ResultSet rs = ps.executeQuery();
            lista=new ArrayList<Post>();
            while(rs.next()){
                Post pos= new Post();
                pos.setId(rs.getInt("id"));
                pos.setFecha(sdf.format(rs.getDate("fecha")));
                pos.setTitulo(rs.getString("titulo"));
                pos.setContenido(rs.getString("contenido"));
                lista.add(pos);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
        return lista;
    }
    
}
