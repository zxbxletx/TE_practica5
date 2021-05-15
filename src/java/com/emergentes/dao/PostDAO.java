package com.emergentes.dao;

import com.emergentes.modelo.Post;
import java.util.List;

public interface PostDAO {
    
    public void insert(Post post) throws Exception;
    public void update(Post post) throws Exception;
    public void delete(int id) throws Exception;
    public Post getById(int id) throws Exception;
    public List<Post> getAll() throws Exception;
     
}
