package project.test.model;
import static org.junit.Assert.*;

import project.dao.SpotiDAO;
import project.model.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;   
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserLikesTest {

    @Test
    public void readUserLikesListTest() {
        System.out.println("--> TEST: readUserLikesList");
        List<User_likes> list = em.createNamedQuery("User_likes.findAll", User_likes.class)
                .getResultList();
        for (User_likes userLikes : list) {
            System.out.println("--> userLikes = "+userLikes.toString());
        }
        assertTrue(list.size()==0);
    }

    @Test
    public void addUserLikesWithDaoTest() {
        System.out.println("--> TEST: addUserLikesWithDao");

        List<User_likes> list = SpotiDAO.getAllUserLikes();
        int userLikesOriginalCount = list.size();
        System.out.println("initial list size is " + userLikesOriginalCount);

        User_likes ul = new User_likes();
        User u=new User();
        u.setId("abc123");
        Artist a=new Artist();
        a.setIdArtist("123abc");
        a.setName("Kylie Minogue");
        SpotiDAO.saveArtist(a);
        SpotiDAO.saveUser(u);
        ul.setArtist(SpotiDAO.getArtistById("123abc"));
        ul.setUser(SpotiDAO.getUserById("abc123"));
        ul.setRating(true);
        System.out.println("--> TEST: addUserLikesWithDao ==> persisting userLikes");
        SpotiDAO.saveUserLikes(ul);
        assertNotNull("Id should not be null", ul.getIdRelation());

        System.out.println("--> TEST: addUserLikesWithDao ==> getting the list");
        list = SpotiDAO.getAllUserLikes();
        assertEquals("Table has two entities", userLikesOriginalCount+1, list.size());

        User_likes newUserLikes = SpotiDAO.getUserLikesById(ul.getIdRelation());
        System.out.println(newUserLikes.getIdRelation());
        System.out.println(newUserLikes.getUser().getId());
        System.out.println(newUserLikes.getArtist().getName());
        System.out.println("UserLikes successfully added with id "+newUserLikes.getIdRelation()+" and user "+newUserLikes.getUser().getId()+" and artist "+newUserLikes.getArtist().getName()+" and like set to: "+newUserLikes.isRating());
        
        System.out.println("--> TEST: addUserLikesWithDao ==> removing new userLikes");
        SpotiDAO.removeUserLikes(newUserLikes);
        SpotiDAO.removeArtist(a);
        SpotiDAO.removeUser(u);
        list = SpotiDAO.getAllUserLikes();
        System.out.println("final list size is " + list.size());
        assertEquals("Table has two entities", userLikesOriginalCount, list.size());
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Testing JPA on SpotiDB database using 'SpotiDB' persistence unit");
        emf = Persistence.createEntityManagerFactory("SpotiDB");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void afterClass() {
        em.close();
        emf.close();
    }

    @Before
    public void before() {
        tx = em.getTransaction();
    }

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private EntityTransaction tx;

}