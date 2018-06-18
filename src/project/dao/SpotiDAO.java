package project.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import project.model.*;

public enum SpotiDAO {
    instance;
    private EntityManagerFactory emf;

    private SpotiDAO() {
        if (emf!=null) {
            emf.close();
        }
        emf = Persistence.createEntityManagerFactory("SpotiDB");
    }

    public EntityManager createEntityManager() {
        try {
            return emf.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    
    }

    public void closeConnections(EntityManager em) {
        em.close();
    }

    public EntityTransaction getTransaction(EntityManager em) {
        return em.getTransaction();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }  
    
    //User
    public static User getUserById(String userId) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        User u = em.find(User.class, userId);
        SpotiDAO.instance.closeConnections(em);
        return u;
    }

    public static List<User> getAllUser() {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        List<User> list = em.createNamedQuery("User.findAll", User.class)
            .getResultList();
        SpotiDAO.instance.closeConnections(em);
        return list;
    }

    public static User saveUser(User u) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(u);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
        return u;
    } 

    public static User updateUser(User u) {
        EntityManager em = SpotiDAO.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        u=em.merge(u);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
        return u;
    }

    public static void removeUser(User u) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        u=em.merge(u);
        em.remove(u);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
    }
    
    //Artist
    public static Artist getArtistById(String artistId) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        Artist a = em.find(Artist.class, artistId);
        SpotiDAO.instance.closeConnections(em);
        return a;
    }

    public static List<Artist> getAllArtist() {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        List<Artist> list = em.createNamedQuery("Artist.findAll", Artist.class)
            .getResultList();
        SpotiDAO.instance.closeConnections(em);
        return list;
    }

    public static Artist saveArtist(Artist a) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(a);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
        return a;
    } 

    public static Artist updateArtist(Artist a) {
        EntityManager em = SpotiDAO.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        a=em.merge(a);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
        return a;
    }

    public static void removeArtist(Artist a) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        a=em.merge(a);
        em.remove(a);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
    }
    
    //Song
    public static Song getSongById(String songId) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        Song s = em.find(Song.class, songId);
        SpotiDAO.instance.closeConnections(em);
        return s;
    }

    public static List<Song> getAllSong() {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        List<Song> list = em.createNamedQuery("Song.findAll", Song.class)
            .getResultList();
        SpotiDAO.instance.closeConnections(em);
        return list;
    }

    public static Song saveSong(Song s) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(s);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
        return s;
    } 

    public static Song updateSong(Song s) {
        EntityManager em = SpotiDAO.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        s=em.merge(s);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
        return s;
    }

    public static void removeSong(Song s) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        s=em.merge(s);
        em.remove(s);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
    }
    
    //User_likes
    public static User_likes getUserLikesById(int idRelation) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        User_likes ul = em.find(User_likes.class, idRelation);
        SpotiDAO.instance.closeConnections(em);
        return ul;
    }

    public static List<User_likes> getAllUserLikes() {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        List<User_likes> list = em.createNamedQuery("User_likes.findAll", User_likes.class)
            .getResultList();
        SpotiDAO.instance.closeConnections(em);
        return list;
    }

    public static User_likes saveUserLikes(User_likes ul) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(ul);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
        return ul;
    } 

    public static User_likes updateUserLikes(User_likes ul) {
        EntityManager em = SpotiDAO.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        ul=em.merge(ul);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
        return ul;
    }

    public static void removeUserLikes(User_likes ul) {
        EntityManager em = SpotiDAO.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        ul=em.merge(ul);
        em.remove(ul);
        tx.commit();
        SpotiDAO.instance.closeConnections(em);
    }
}