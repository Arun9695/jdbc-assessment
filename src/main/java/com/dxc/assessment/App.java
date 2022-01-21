package com.dxc.assessment;

import java.sql.SQLException;
import java.util.List;
import com.dxc.assessment.dao.*;
import com.dxc.assessment.modal.Author;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        ctx.refresh();

        Author roni = new Author(1,"Roni", "George", "fiction","roni@gmail.com");
        Author dune = new Author(2,"Dune", "Frank", "scifi","dune@gmail.com");
        Author Hobbit = new Author(3,"The Hobbit", "Tolkien", "action","hobbit@gmail.com");
        Author Rings =
                new Author(4,"Rings", "Tolkien", "action","ring@gmail.com");
        Author Silmarillion = new Author(6,"Silmarillion", "J.R.R", "comedy","simi@gmail.com");
        Author Narnia =
                new Author(7,"Narnia", "Lewis", "science","narnia@gmail.com");

        List<Author> authors = List.of(roni, dune, Hobbit, Rings, Silmarillion,
                Narnia);

        AuthorDao authorDao = ctx.getBean("authorDao", AuthorDao.class);

        authors.forEach(bk -> {
            int rows = authorDao.save(bk);
            System.out.println("Rows affected: " + rows);
        });

        authorDao.findAll().forEach(System.out::println);

        ctx.registerShutdownHook();
    }
}