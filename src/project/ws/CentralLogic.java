package project.ws;
import project.model.*;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use; 
//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface CentralLogic{ 
	//db operations
    @WebMethod(operationName="initDB") @WebResult(name="string") public String initDB();
    
    //user operations
    @WebMethod(operationName="createUser") @WebResult(name="user") public User createUser(String id, String chatId);
    @WebMethod(operationName="getUser") @WebResult(name="user") public User getUser(String id);
    @WebMethod(operationName="deleteUser") @WebResult(name="int") public int deleteUser(User u);
    @WebMethod(operationName="getAllUser") @WebResult(name="users") public List<User> getAllUser();
    
    //artist operations
    //@WebMethod(operationName="createArtist") @WebResult(name="artist") public Artist createArtist(String name);
    @WebMethod(operationName="getArtist") @WebResult(name="artist") public Artist getArtist(String name);
   // @WebMethod(operationName="updateArtist") @WebResult(name="artist") public Artist updateArtist(Artist a);
    @WebMethod(operationName="getAllArtist") @WebResult(name="artists") public List<Artist> getAllArtist();
    @WebMethod(operationName="deleteArtist") @WebResult(name="int") public int deleteArtist(Artist a);
    
    //song operations
    //@WebMethod Song createSong(String name);
    @WebMethod(operationName="getSong") @WebResult(name="song") public Song getSong(String name);
    //@WebMethod Song updateSong(Song s);
    @WebMethod(operationName="getAllSong") @WebResult(name="songs") public List<Song> getAllSong();
    @WebMethod(operationName="deleteSong") @WebResult(name="int") public int deleteSong(Song s);
    
    //userlikes operations
    //@WebMethod User_likes createUserLikeArtist(User u, Artist a, boolean like)
    //@WebMethod User_likes createUserLikeSong(User u, Song s, boolean like)
    @WebMethod(operationName="getUserLikeArtist") @WebResult(name="int") int getUserLikeArtist(User u, Artist a);
    @WebMethod(operationName="getUserLikeSong") @WebResult(name="int") int getUserLikeSong(User u, Song s);
    //@WebMethod int updateUserLikeArtist(User u, Artist a)
    //@WebMethod int updateUserLikeSong(User u, Song s)
    @WebMethod(operationName="deleteUserLikeArtist") @WebResult(name="int") int deleteUserLikeArtist(User u, Artist a);
    @WebMethod(operationName="deleteUserLikeSong") @WebResult(name="int") int deleteUserLikeSong(User u, Song s);
    
    //functions
    @WebMethod(operationName="addRatingArtist") @WebResult(name="int") int addRatingArtist(User u, Artist a, boolean b);
    @WebMethod(operationName="addRatingSong") @WebResult(name="int") int addRatingSong(User u, Song s, boolean b);
    @WebMethod(operationName="getSongsFromArtist") @WebResult(name="songs") List<Song> getSongsFromArtist(Artist a);
    @WebMethod(operationName="getLikedSongs") @WebResult(name="songs") List<Song> getLikedSongs (User u);
    @WebMethod(operationName="getDislikedSongs") @WebResult(name="songs") List<Song> getDislikedSongs (User u);
    @WebMethod(operationName="getLikedArtists") @WebResult(name="artists") List<Artist> getLikedArtists (User u);
    @WebMethod(operationName="getDislikedArtists") @WebResult(name="artists") List<Artist> getDislikedArtists (User u);
    @WebMethod(operationName="getRecommendation") @WebResult(name="songs") List<Song> getRecommendation(User u);
    @WebMethod(operationName="initSongs") @WebResult(name="songs") List<Song> initSongs(); 
}