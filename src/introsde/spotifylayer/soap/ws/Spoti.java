
package introsde.spotifylayer.soap.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Spoti", targetNamespace = "http://ws.soap.spotifylayer.introsde/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Spoti {


    /**
     * 
     * @param artistName
     * @return
     *     returns introsde.spotifylayer.soap.ws.Artist
     */
    @WebMethod
    @WebResult(name = "artist", targetNamespace = "")
    @RequestWrapper(localName = "searchArtist", targetNamespace = "http://ws.soap.spotifylayer.introsde/", className = "introsde.spotifylayer.soap.ws.SearchArtist")
    @ResponseWrapper(localName = "searchArtistResponse", targetNamespace = "http://ws.soap.spotifylayer.introsde/", className = "introsde.spotifylayer.soap.ws.SearchArtistResponse")
    @Action(input = "http://ws.soap.spotifylayer.introsde/Spoti/searchArtistRequest", output = "http://ws.soap.spotifylayer.introsde/Spoti/searchArtistResponse")
    public Artist searchArtist(
        @WebParam(name = "artistName", targetNamespace = "")
        String artistName);

    /**
     * 
     * @param songName
     * @return
     *     returns introsde.spotifylayer.soap.ws.Song
     */
    @WebMethod
    @WebResult(name = "song", targetNamespace = "")
    @RequestWrapper(localName = "searchSong", targetNamespace = "http://ws.soap.spotifylayer.introsde/", className = "introsde.spotifylayer.soap.ws.SearchSong")
    @ResponseWrapper(localName = "searchSongResponse", targetNamespace = "http://ws.soap.spotifylayer.introsde/", className = "introsde.spotifylayer.soap.ws.SearchSongResponse")
    @Action(input = "http://ws.soap.spotifylayer.introsde/Spoti/searchSongRequest", output = "http://ws.soap.spotifylayer.introsde/Spoti/searchSongResponse")
    public Song searchSong(
        @WebParam(name = "songName", targetNamespace = "")
        String songName);

    /**
     * 
     * @param artistId
     * @return
     *     returns java.util.List<introsde.spotifylayer.soap.ws.Song>
     */
    @WebMethod
    @WebResult(name = "songs", targetNamespace = "")
    @RequestWrapper(localName = "getTopTracksByArtist", targetNamespace = "http://ws.soap.spotifylayer.introsde/", className = "introsde.spotifylayer.soap.ws.GetTopTracksByArtist")
    @ResponseWrapper(localName = "getTopTracksByArtistResponse", targetNamespace = "http://ws.soap.spotifylayer.introsde/", className = "introsde.spotifylayer.soap.ws.GetTopTracksByArtistResponse")
    @Action(input = "http://ws.soap.spotifylayer.introsde/Spoti/getTopTracksByArtistRequest", output = "http://ws.soap.spotifylayer.introsde/Spoti/getTopTracksByArtistResponse")
    public List<Song> getTopTracksByArtist(
        @WebParam(name = "artistId", targetNamespace = "")
        String artistId);

    /**
     * 
     * @param artistSeeds
     * @param songSeeds
     * @return
     *     returns java.util.List<introsde.spotifylayer.soap.ws.Song>
     */
    @WebMethod
    @WebResult(name = "songs", targetNamespace = "")
    @RequestWrapper(localName = "getRecommendation", targetNamespace = "http://ws.soap.spotifylayer.introsde/", className = "introsde.spotifylayer.soap.ws.GetRecommendation")
    @ResponseWrapper(localName = "getRecommendationResponse", targetNamespace = "http://ws.soap.spotifylayer.introsde/", className = "introsde.spotifylayer.soap.ws.GetRecommendationResponse")
    @Action(input = "http://ws.soap.spotifylayer.introsde/Spoti/getRecommendationRequest", output = "http://ws.soap.spotifylayer.introsde/Spoti/getRecommendationResponse")
    public List<Song> getRecommendation(
        @WebParam(name = "artistSeeds", targetNamespace = "")
        String artistSeeds,
        @WebParam(name = "songSeeds", targetNamespace = "")
        String songSeeds);

}
