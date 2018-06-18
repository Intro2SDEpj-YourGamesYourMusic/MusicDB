package project.test.model;
import static org.junit.Assert.*;

import project.dao.SpotiDAO;
import project.model.Artist;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;   
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArtistTest {

    @Test
    public void readArtistListTest() {
        System.out.println("--> TEST: readArtistList");
        List<Artist> list = em.createNamedQuery("Artist.findAll", Artist.class)
                .getResultList();
        for (Artist artist : list) {
            System.out.println("--> artist = "+artist.toString());
        }
        assertTrue(list.size()==0);
    }

    @Test
    public void addArtistWithDaoTest() {
        System.out.println("--> TEST: addArtistWithDao");

        List<Artist> list = SpotiDAO.getAllArtist();
        int artistOriginalCount = list.size();

        Artist a = new Artist();
        a.setIdArtist("ab12345");
        a.setName("Avicii");
        System.out.println("--> TEST: addArtistWithDao ==> persisting artist");
        SpotiDAO.saveArtist(a);
        assertNotNull("Id should not be null", a.getIdArtist());

        System.out.println("--> TEST: addArtistWithDao ==> getting the list");
        list = SpotiDAO.getAllArtist();
        assertEquals("Table has two entities", artistOriginalCount+1, list.size());

        Artist newArtist = SpotiDAO.getArtistById(a.getIdArtist());
        System.out.println("Artist successfully added with id "+newArtist.getIdArtist()+"and name "+newArtist.getName());

        System.out.println("--> TEST: addArtistWithDao ==> removing new artist");
        SpotiDAO.removeArtist(newArtist);
        list = SpotiDAO.getAllArtist();
        assertEquals("Table has two entities", artistOriginalCount, list.size());
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