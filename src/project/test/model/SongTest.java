package project.test.model;
import static org.junit.Assert.*;

import project.dao.SpotiDAO;
import project.model.Song;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;   
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SongTest {

    @Test
    public void readSongListTest() {
        System.out.println("--> TEST: readSongList");
        List<Song> list = em.createNamedQuery("Song.findAll", Song.class)
                .getResultList();
        for (Song song : list) {
            System.out.println("--> song = "+song.toString());
        }
        assertTrue(list.size()==0);
    }

    @Test
    public void addSongWithDaoTest() {
        System.out.println("--> TEST: addSongWithDao");

        List<Song> list = SpotiDAO.getAllSong();
        int songOriginalCount = list.size();

        Song s = new Song();
        s.setIdSong("ab12345");
        s.setName("Levels");
        System.out.println("--> TEST: addSongWithDao ==> persisting song");
        SpotiDAO.saveSong(s);
        assertNotNull("Id should not be null", s.getIdSong());

        System.out.println("--> TEST: addSongWithDao ==> getting the list");
        list = SpotiDAO.getAllSong();
        assertEquals("Table has two entities", songOriginalCount+1, list.size());

        Song newSong = SpotiDAO.getSongById(s.getIdSong());
        System.out.println("Song successfully added with id "+newSong.getIdSong()+"and name "+newSong.getName());

        System.out.println("--> TEST: addSongWithDao ==> removing new song");
        SpotiDAO.removeSong(newSong);
        list = SpotiDAO.getAllSong();
        assertEquals("Table has two entities", songOriginalCount, list.size());
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