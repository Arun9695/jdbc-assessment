package com.dxc.assessment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;
import java.util.List;
import com.dxc.assessment.modal.Author;

public class AuthorDaoImpl implements AuthorDao {
    private DataSource dataSource;

    private static final String INSERT_ONE_AUTHOR;
    
    private static final String SELECT_ALL_AUTHORS;
    static {
        INSERT_ONE_AUTHOR = "INSERT INTO authors (id, first_name, last_name, genre, email) VALUES (?, ?, ?, ?, ?)";
        SELECT_ALL_AUTHORS = "SELECT * FROM authors";
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Author create(Author author) throws SQLException{
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_ONE_AUTHOR);
        ps.setLong(1, author.getId());
        ps.setString(2, author.getFirstName());
        ps.setString(3, author.getLastName());
        ps.setString(4, author.getGenre());
        ps.setString(5, author.getEmail());

        int rows = 0;
        rows = ps.executeUpdate();

        return null;
    }

    @Override
    public Author findById(Long id) {
        return null;
    }

    @Override
    public List<Author> findByGenre(String genre) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        Connection connection = dataSource.getConnection();
        List<Author> books;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SELECT_ALL_AUTHORS);
        authors = new ArrayList();
        while (rs.next()) {
            authors.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }
        rs.close();
        statement.close();
        connection.close();
        return null;
    }

    @Override
    public int save(Author bk) {
        // TODO Auto-generated method stub
        return 0;
    }

}
