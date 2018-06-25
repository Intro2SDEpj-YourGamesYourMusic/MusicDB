package project.ws;
import introsde.spotifylayer.soap.ws.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jws.WebService;

import project.dao.SpotiDAO;
import project.model.*;
import project.model.Artist;
import project.model.Song;
//Service Implementation
@WebService(endpointInterface = "project.ws.CentralLogic")
public class CentralLogicImpl implements CentralLogic {
	SpotiImplService apiService=new SpotiImplService();
	Spoti api=apiService.getSpotiImplPort();
    @Override
    public String initDB() {
    	List<User_likes> ulList=new ArrayList<User_likes>();
    	ulList=SpotiDAO.getAllUserLikes();
    	if(ulList.size()>0)
    		for(User_likes ul:ulList)
    			SpotiDAO.removeUserLikes(ul);
    	List<User> uList=new ArrayList<User>();
    	uList=SpotiDAO.getAllUser();
    	if(uList.size()>0)
    		for(User u:uList)
    			SpotiDAO.removeUser(u);
    	List<Artist> aList=new ArrayList<Artist>();
    	aList=SpotiDAO.getAllArtist();
    	if(aList.size()>0)
    		for(Artist a:aList)
    			SpotiDAO.removeArtist(a);
    	List<Song> sList=new ArrayList<Song>();
    	sList=SpotiDAO.getAllSong();
    	if(sList.size()>0)
    		for(Song s:sList)
    			SpotiDAO.removeSong(s);
    	return "DB initialized. You have \n"+SpotiDAO.getAllUser().size()+" users.\n"+SpotiDAO.getAllArtist().size()+" artists.\n"+SpotiDAO.getAllSong().size()+" songs\n"+SpotiDAO.getAllUserLikes().size()+" likes.";
    }

	@Override
	public User createUser(String id, String chatId) {
		User u=SpotiDAO.getUserById(id);
		if(u!=null) {
			return u;
		}
		u=new User();
		u.setId(id);
		u.setChatId(chatId);
		SpotiDAO.saveUser(u);
		return SpotiDAO.getUserById(id);
	}

	@Override
	public User getUser(String id) {
		User u=SpotiDAO.getUserById(id);
		if(u!=null) {
			return u;
		}
		return null;
	}

	@Override
	public int deleteUser(User u) {
		SpotiDAO.removeUser(u);
		return 1;
	}

	@Override
	public List<User> getAllUser() {
		return SpotiDAO.getAllUser();
	}

	/*@Override
	public Artist createArtist(String name) {
		introsde.spotifylayer.soap.ws.Artist apiA=api.searchArtist(name);
		Artist a=artistDB_fromAPI(apiA);
		SpotiDAO.saveArtist(a);
		return a;
	}*/

	@Override
	public Artist getArtist(String name) {
		List<Artist> artistList=SpotiDAO.getAllArtist();
		for(Artist a : artistList) {
			if(a.getName().equals(name)) {
				return a;
			}
		}
		introsde.spotifylayer.soap.ws.Artist apiArtist=api.searchArtist(name);
		Artist a=artistDB_fromAPI(apiArtist);
		SpotiDAO.saveArtist(a);
		return a;	
	}

	/*
	public Artist updateArtist(Artist a) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<Artist> getAllArtist() {
		List<Artist> artistList=new ArrayList<Artist>();
		artistList=SpotiDAO.getAllArtist();
		return artistList;
	}

	@Override
	public int deleteArtist(Artist a) {
		SpotiDAO.removeArtist(a);
		return 1;
	}
/*
	@Override
	public Song createSong(String name) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public Song getSong(String name) {
		List<Song> songList=SpotiDAO.getAllSong();
		for(Song s : songList)
			if(s.getName().equals(name))
				return s;
		introsde.spotifylayer.soap.ws.Song apiSong=api.searchSong(name);
		Song s=songDB_fromAPI(apiSong);
		SpotiDAO.saveSong(s);
		return s;	
	} 

	/*@Override
	public Song updateSong(Song s) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<Song> getAllSong() {
		return SpotiDAO.getAllSong();
	}

	@Override
	public int deleteSong(Song s) {
		SpotiDAO.removeSong(s);
		return 1;
	}

	/*@Override
	public int addLikeArtist(User u, Artist a) {
		User_likes ul=new User_likes();
		ul.setArtist(a);
		ul.setUser(u);
		ul.setRating(true);
		SpotiDAO.saveUserLikes(ul);
		return 1;
	}

	/*@Override
	public List<Song> getSongsFromArtist(String artistName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> getLikedSongs(User u) {
		List<Song> songList=new ArrayList<Song>();
		List<User_likes> ulList=SpotiDAO.getAllUserLikes();
		for (User_likes ul : ulList)
			if(ul.getUser()==u && ul.getSong()!=null && ul.isRating()==true)
				songList.add(ul.getSong());
		return songList;
	}

	@Override
	public List<Song> getDislikedSongs(User u) {
		List<Song> songList=new ArrayList<Song>();
		List<User_likes> ulList=SpotiDAO.getAllUserLikes();
		for (User_likes ul : ulList)
			if(ul.getUser()==u && ul.getSong()!=null && ul.isRating()==false)
				songList.add(ul.getSong());
		return songList;
	}

	@Override
	public List<Artist> getLikedArtists(User u) {
		List<Artist> artistList=new ArrayList<Artist>();
		List<User_likes> ulList=SpotiDAO.getAllUserLikes();
		for (User_likes ul : ulList)
			if(ul.getUser()==u && ul.getArtist()!=null && ul.isRating()==true)
				artistList.add(ul.getArtist());
		return artistList;
	}

	@Override
	public List<Artist> getDislikedArtists(User u) {
		List<Artist> artistList=new ArrayList<Artist>();
		List<User_likes> ulList=SpotiDAO.getAllUserLikes();
		for (User_likes ul : ulList)
			if(ul.getUser()==u && ul.getArtist()!=null && ul.isRating()==false)
				artistList.add(ul.getArtist());
		return artistList;
	}*/
	
	private Artist artistDB_fromAPI (introsde.spotifylayer.soap.ws.Artist a) {
		Artist new_a=new Artist();
		new_a.setIdArtist(a.getIdArtist());
		new_a.setName(a.getName());
		return new_a;
	}
	private Song songDB_fromAPI(introsde.spotifylayer.soap.ws.Song s) {
		Song new_s=new Song();
		new_s.setIdSong(s.getIdSong());
		new_s.setName(s.getName());
		new_s.setArtistName(s.getArtistName());
		return new_s;
	}
/*
	@Override
	public int addLikeSong(User u, Song s) {
		User_likes ul=new User_likes();
		ul.setSong(s);
		ul.setUser(u);
		ul.setRating(true);
		SpotiDAO.saveUserLikes(ul);
		return 1;
	} */

	@Override
	public int getUserLikeArtist(User u, Artist a) {
		User user=SpotiDAO.getUserById(u.getId());
		Artist artist=SpotiDAO.getArtistById(a.getIdArtist());
		if (user!=null && artist!=null) {
			List<User_likes> ulikes=SpotiDAO.getAllUserLikes();
			for(User_likes ul:ulikes) {
				if(ul.getArtist()!=null)
					if(ul.getArtist().getIdArtist().equals(artist.getIdArtist()) && ul.getUser().getId().equals(user.getId())) {
						if(ul.isRating())
							return 1;
						return 0;
					}
			}
		}
		return -1;
	}

	@Override
	public int getUserLikeSong(User u, Song s) {
		User user=SpotiDAO.getUserById(u.getId());
		Song song=SpotiDAO.getSongById(s.getIdSong());
		if (user!=null && song!=null) {
			List<User_likes> ulikes=SpotiDAO.getAllUserLikes();
			for(User_likes ul:ulikes) {
				if(ul.getSong()!=null)
					if(ul.getSong().getIdSong().equals(song.getIdSong()) && ul.getUser().getId().equals(user.getId())) {
						if(ul.isRating())
							return 1;
						return 0;
					}
			}
		}
		return -1;
	}

	@Override
	public int addRatingArtist(User u, Artist a, boolean b) {
		User user=SpotiDAO.getUserById(u.getId());
		Artist artist=SpotiDAO.getArtistById(a.getIdArtist());
		if (user!=null && artist!=null) {
			List<User_likes> ulikes=SpotiDAO.getAllUserLikes();
			for(User_likes ul:ulikes) {
				if(ul.getArtist()!=null)
					if(ul.getArtist().getIdArtist().equals(artist.getIdArtist()) && ul.getUser().getId().equals(user.getId()))
						return 0;
			}
			User_likes ul=new User_likes();
			ul.setArtist(artist);
			ul.setUser(user);
			ul.setRating(b);
			SpotiDAO.saveUserLikes(ul);
			return 1;
		}
		return 0;
	}

	@Override
	public int addRatingSong(User u, Song s, boolean b) {
		User user=SpotiDAO.getUserById(u.getId());
		Song song=SpotiDAO.getSongById(s.getIdSong());
		if (user!=null && song!=null) {
			List<User_likes> ulikes=SpotiDAO.getAllUserLikes();
			for(User_likes ul:ulikes) {
				if (ul.getSong()!=null)
					if(ul.getSong().getIdSong().equals(song.getIdSong()) && ul.getUser().getId().equals(user.getId()))
						return 0;
			}
			User_likes ul=new User_likes();
			ul.setSong(song);
			ul.setUser(user);
			ul.setRating(b);
			SpotiDAO.saveUserLikes(ul);
			return 1;
		}
		return 0;
	}

	@Override
	public List<Song> getSongsFromArtist(Artist a) {
		List<introsde.spotifylayer.soap.ws.Song> apiSongList=api.getTopTracksByArtist(a.getIdArtist());
		List<Song> songList=new ArrayList<Song>();
		for(int i=0;i<5;i++) {
			introsde.spotifylayer.soap.ws.Song s=apiSongList.get(i);
			Song song=(songDB_fromAPI(s));
			song.setArtistName(a.getName());
			songList.add(song);
		}
		return songList;
	}

	@Override
	public List<Song> getLikedSongs(User u) {
		List<User_likes> ulList=SpotiDAO.getAllUserLikes();
		List<Song> returnList=new ArrayList<Song>();
		for(User_likes ul:ulList) {
			if(ul.getUser().getId().equals(u.getId()) && ul.getSong()!=null && ul.isRating()) {
				returnList.add(ul.getSong());
			}
					
		}
		return returnList;
	}

	@Override
	public List<Song> getDislikedSongs(User u) {
		List<User_likes> ulList=SpotiDAO.getAllUserLikes();
		List<Song> returnList=new ArrayList<Song>();
		for(User_likes ul:ulList) {
			if(ul.getUser().getId().equals(u.getId()) && ul.getSong()!=null && !ul.isRating()) {
				returnList.add(ul.getSong());
			}
					
		}
		return returnList;
	}

	@Override
	public List<Artist> getLikedArtists(User u) {
		List<User_likes> ulList=SpotiDAO.getAllUserLikes();
		List<Artist> returnList=new ArrayList<Artist>();
		for(User_likes ul:ulList) {
			if(ul.getUser().getId().equals(u.getId()) && ul.getArtist()!=null && ul.isRating()) {
				returnList.add(ul.getArtist());
			}
					
		}
		return returnList;
	}

	@Override
	public List<Artist> getDislikedArtists(User u) {
		List<User_likes> ulList=SpotiDAO.getAllUserLikes();
		List<Artist> returnList=new ArrayList<Artist>();
		for(User_likes ul:ulList) {
			if(ul.getUser().getId().equals(u.getId()) && ul.getArtist()!=null && !ul.isRating()) {
				returnList.add(ul.getArtist());
			}
					
		}
		return returnList;
	}

	@Override
	public int deleteUserLikeArtist(User u, Artist a) {
		User user=SpotiDAO.getUserById(u.getId());
		Artist artist=SpotiDAO.getArtistById(a.getIdArtist());
		if (user!=null && artist!=null) {
			List<User_likes> ulikes=SpotiDAO.getAllUserLikes();
			for(User_likes ul:ulikes) {
				if(ul.getArtist()!=null)
					if(ul.getArtist().getIdArtist().equals(artist.getIdArtist()) && ul.getUser().getId().equals(user.getId())) {
						SpotiDAO.removeUserLikes(ul);
						return 1;
					}
			}
		}
		return -1;
	}

	@Override
	public int deleteUserLikeSong(User u, Song s) {
		User user=SpotiDAO.getUserById(u.getId());
		Song song=SpotiDAO.getSongById(s.getIdSong());
		if (user!=null && song!=null) {
			List<User_likes> ulikes=SpotiDAO.getAllUserLikes();
			for(User_likes ul:ulikes) {
				if(ul.getSong()!=null)
					if(ul.getSong().getIdSong().equals(song.getIdSong()) && ul.getUser().getId().equals(user.getId())) {
						SpotiDAO.removeUserLikes(ul);
						return 1;
					}
			}
		}
		return -1;
	}

	@Override
	public List<Song> getRecommendation(User u) {
		List<User_likes> allUlList=SpotiDAO.getAllUserLikes();
		List<User_likes> userUlList=new ArrayList<User_likes>();
		List<Song> returnList=new ArrayList<Song>();
		List<String> songList=new ArrayList<String>();
		List<String> artistList=new ArrayList<String>();
		System.out.println("Ok, i'm ready, trying with user "+u.getId());
		for(User_likes ul:allUlList) {
			if(ul.getUser().getId().equals(u.getId())&&ul.isRating()) {
				userUlList.add(ul);
			}
		}
		System.out.println("I found some userlikes:" +userUlList.size());
		Collections.shuffle(userUlList);
		for(int i=0;i<userUlList.size()&&i<5;i++) {
			if(userUlList.get(i).getSong()!=null)
				songList.add(userUlList.get(i).getSong().getIdSong());
			else if(userUlList.get(i).getArtist()!=null)
				artistList.add(userUlList.get(i).getArtist().getIdArtist());
		}
		System.out.println("Now i search recommendations for " + songList.size()+" songs and" + artistList.size()+ " artists");
		List<introsde.spotifylayer.soap.ws.Song> apiSongs=api.getRecommendation(String.join(",", artistList), String.join(",", songList));
		System.out.println("I found "+apiSongs.size()+" songs");
		for(introsde.spotifylayer.soap.ws.Song s:apiSongs) {
			returnList.add(songDB_fromAPI(s));
		}
		System.out.println("i'm about to return "+returnList.size()+" songs");
		return returnList;
	}

	@Override
	public List<Song> initSongs() {
		List<Song> returnList=new ArrayList<Song>();
		returnList.add(getSong("Wake me up"));
		returnList.add(getSong("Country Roads"));
		returnList.add(getSong("Mockingbird"));
		returnList.add(getSong("Bohemian Rhapsody"));
		returnList.add(getSong("Girls Like You"));
		
		return returnList;
	}
}