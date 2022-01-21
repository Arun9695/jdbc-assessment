package com.dxc.assessment.dao;

import java.util.List;
import com.dxc.assessment.modal.Author;

public interface AuthorDao {

    Author create(Author author);

    Author findById(Long id);
    
    List<Author> findByGenre(String genre);

    List<Author> findAll();

    int save(Author bk);
    
}
