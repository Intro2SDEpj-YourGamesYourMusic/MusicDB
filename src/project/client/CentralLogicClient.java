package project.client;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import project.model.Artist;
import project.model.Song;
import project.model.User;
import project.ws.CentralLogic;
public class CentralLogicClient {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:6900/ws/hello?wsdl");
        QName qname = new QName("http://ws.project/", "CentralLogicImplService");
        Service service = Service.create(url, qname);
        CentralLogic centralLogic = service.getPort(CentralLogic.class);
        
        //initdb
        System.out.println(centralLogic.initDB());
        //create user
        User u1=centralLogic.createUser("abc123", "eskeree1");
        System.out.println("Created user "+u1.getId());
        User u2=centralLogic.createUser("def456", "eskeree2");
        System.out.println("Created user "+u2.getId());
        
        //create artist
        Artist artistA=centralLogic.getArtist("Linkin Park");
        System.out.println(artistA.getIdArtist());
        Artist artistB=centralLogic.getArtist("Imagine Dragons");
        System.out.println(artistB.getIdArtist());
        
        //create song
        Song songA=centralLogic.getSong("Radioactive");
        System.out.println(songA.getIdSong() +" "+ songA.getArtistName()+" "+songA.getName());
        Song songB=centralLogic.getSong("In my remains");
        System.out.println(songB.getIdSong());
        System.out.println("I put Linkin Park as like in u1: "+centralLogic.addRatingArtist(u1, artistA, true));
        System.out.println("I put In My Remains as like in u1 "+centralLogic.addRatingSong(u1, songB, true));
        System.out.println("I put Imagine Dragons as dislike in u2: "+centralLogic.addRatingArtist(u2, artistB, false));
        System.out.println("I put Radioactive as dislike in u2: "+centralLogic.addRatingSong(u2, songA, false));
        System.out.println("I put Linkin Park as like in u1: "+centralLogic.addRatingArtist(u1, artistA, true));
        System.out.println("I put In My Remains as like in u1 "+centralLogic.addRatingSong(u1, songB, true));
        System.out.println("I put Imagine Dragons as dislike in u2: "+centralLogic.addRatingArtist(u2, artistB, false));
        System.out.println("I put Radioactive as dislike in u2: "+centralLogic.addRatingSong(u2, songA, false));
        System.out.println("Linkin Park in u1: "+centralLogic.getUserLikeArtist(u1, artistA));
        System.out.println("In My Remains in u1 "+centralLogic.getUserLikeSong(u1, songB));
        System.out.println("Imagine Dragons in u2: "+centralLogic.getUserLikeArtist(u2, artistB));
        System.out.println("Radioactive in u2: "+centralLogic.getUserLikeSong(u2, songA));
        System.out.println("Linkin Park in u2: "+centralLogic.getUserLikeArtist(u2, artistA));
        System.out.println("In My Remains in u2 "+centralLogic.getUserLikeSong(u2, songB));
        System.out.println("Imagine Dragons in u1: "+centralLogic.getUserLikeArtist(u1, artistB));
        System.out.println("Radioactive in u1: "+centralLogic.getUserLikeSong(u1, songA));
        try{Artist fakeArtist=new Artist();
        List<Song> songList=centralLogic.getSongsFromArtist(fakeArtist);
        for(Song s:songList)
        	System.out.println(s.getIdSong()+" "+s.getArtistName()+" "+s.getName());
        }catch(Exception e) {System.out.println("Artist not found");} 
        System.out.println("User u1 likes: "+centralLogic.getLikedArtists(u1).size()+" artists");
        System.out.println("User u1 dislikes: "+centralLogic.getDislikedArtists(u1).size()+" artists");
        System.out.println("User u1 likes: "+centralLogic.getLikedSongs(u1).size()+" songs");
        System.out.println("User u1 dislikes: "+centralLogic.getDislikedSongs(u1).size()+" songs");
        System.out.println("User u2 likes: "+centralLogic.getLikedArtists(u2).size()+" artists");
        System.out.println("User u2 dislikes: "+centralLogic.getDislikedArtists(u2).size()+" artists");
        System.out.println("User u2 likes: "+centralLogic.getLikedSongs(u2).size()+" songs");
        System.out.println("User u2 dislikes: "+centralLogic.getDislikedSongs(u2).size()+" songs");
        centralLogic.deleteUserLikeArtist(u1, artistA);
        centralLogic.deleteUserLikeArtist(u2, artistB);
        System.out.println();
        System.out.println("User u1 likes: "+centralLogic.getLikedArtists(u1).size()+" artists");
        System.out.println("User u1 dislikes: "+centralLogic.getDislikedArtists(u1).size()+" artists");
        System.out.println("User u1 likes: "+centralLogic.getLikedSongs(u1).size()+" songs");
        System.out.println("User u1 dislikes: "+centralLogic.getDislikedSongs(u1).size()+" songs");
        System.out.println("User u2 likes: "+centralLogic.getLikedArtists(u2).size()+" artists");
        System.out.println("User u2 dislikes: "+centralLogic.getDislikedArtists(u2).size()+" artists");
        System.out.println("User u2 likes: "+centralLogic.getLikedSongs(u2).size()+" songs");
        System.out.println("User u2 dislikes: "+centralLogic.getDislikedSongs(u2).size()+" songs");
        
        User myuser=centralLogic.createUser("dega93", "telegramchatid123");
        Artist artist1=centralLogic.getArtist("Linkin Park");
        Artist artist2=centralLogic.getArtist("Avicii");
        Artist artist3=centralLogic.getArtist("Rea Garvey");
        Artist artist4=centralLogic.getArtist("Green Day");
        Artist artist5=centralLogic.getArtist("David Guetta");
        Artist artist6=centralLogic.getArtist("Skrillex");
        Song song1=centralLogic.getSong("Guilty all the same");
        Song song2=centralLogic.getSong("The nights");
        Song song3=centralLogic.getSong("Levels");
        Song song4=centralLogic.getSong("Make it bun dem");
        Song song5=centralLogic.getSong("Party rock");
        Song song6=centralLogic.getSong("My immortal");
        centralLogic.addRatingArtist(myuser, artist1, true);
        centralLogic.addRatingArtist(myuser, artist2, true);
        centralLogic.addRatingArtist(myuser, artist3, true);
        centralLogic.addRatingArtist(myuser, artist4, true);
        centralLogic.addRatingArtist(myuser, artist5, true);
        centralLogic.addRatingArtist(myuser, artist6, true);
        centralLogic.addRatingSong(myuser, song1, true);
        centralLogic.addRatingSong(myuser, song2, true);
        centralLogic.addRatingSong(myuser, song3, true);
        centralLogic.addRatingSong(myuser, song4, true);
        centralLogic.addRatingSong(myuser, song5, true);
        centralLogic.addRatingSong(myuser, song6, true);
        List<Song> myuser_recommendations=centralLogic.getRecommendation(myuser);
        for(Song recSong:myuser_recommendations) {
        	System.out.println(recSong.getIdSong()+" "+recSong.getArtistName()+" "+recSong.getName());
        }
        List<Song> initList=centralLogic.initSongs();
        for(Song s:initList) {
        	System.out.println(s.getIdSong()+" "+s.getArtistName()+" "+s.getName());
        }
        
    }
}