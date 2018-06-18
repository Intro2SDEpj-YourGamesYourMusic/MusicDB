package project.test.model;
import static org.junit.Assert.*;

import project.dao.SpotiDAO;
import project.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;   
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

    @Test
    public void readUserListTest() {
        System.out.println("--> TEST: readUserList");
        List<User> list = em.createNamedQuery("User.findAll", User.class)
                .getResultList();
        for (User user : list) {
            System.out.println("--> user = "+user.toString());
        }
        assertTrue(list.size()==0);
    }

    @Test
    public void addUserWithDaoTest() {
        System.out.println("--> TEST: addUserWithDao");

        List<User> list = SpotiDAO.getAllUser();
        int userOriginalCount = list.size();

        User u = new User();
        u.setId("ab12345");
        
        System.out.println("--> TEST: addUserWithDao ==> persisting user");
        SpotiDAO.saveUser(u);
        assertNotNull("Id should not be null", u.getId());

        System.out.println("--> TEST: addUserWithDao ==> getting the list");
        list = SpotiDAO.getAllUser();
        System.out.println(list.size());
        assertEquals("Table has two entities", userOriginalCount+1, list.size());

        User newUser = SpotiDAO.getUserById(u.getId());
        System.out.println("User successfully added with id: "+newUser.getId());

        System.out.println("--> TEST: addUserWithDao ==> removing new user");
        SpotiDAO.removeUser(newUser);
        list = SpotiDAO.getAllUser();
        System.out.println(list.size());
        assertEquals("Table has two entities", userOriginalCount, list.size());
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