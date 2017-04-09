package com.polytech.repository;

import com.polytech.business.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev on 3/13/17.
 */
//@Component
@Repository
@Transactional
public class JpaPostRepository implements PostRepository{


    @PersistenceContext
    private EntityManager entityManager;

    public JpaPostRepository(){

    }

    public List<Post> findAll() {
        //Langage JPQL
        String req = "SELECT p FROM Post p ORDER BY p DESC";
        Query query = entityManager.createQuery(req);
        return query.getResultList();
        //JDBC
        /*List<Post> allPosts = new ArrayList<Post>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM POST");
            while (resultSet.next()){
                allPosts.add(new Post(resultSet.getString("CONTENT")));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return allPosts;*/
    }

    public void save(Post post) {
        entityManager.persist(post);
        //JDBC
        /*try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO POST (CONTENT) VALUES(?)");
            preparedStatement.setString(1,post.getContent());
            preparedStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }*/
    }

    public void delete(long postID){
        String req = "DELETE FROM Likes l WHERE l.postID = " + postID;
        Query query = entityManager.createQuery(req);
        query.executeUpdate();
        String req2 = "DELETE FROM Comment c WHERE c.postID = " + postID;
        Query query2 = entityManager.createQuery(req2);
        query2.executeUpdate();
        String req3 = "DELETE FROM Post p WHERE p.id = " + postID;
        Query query3 = entityManager.createQuery(req3);
        query3.executeUpdate();
    }
}
