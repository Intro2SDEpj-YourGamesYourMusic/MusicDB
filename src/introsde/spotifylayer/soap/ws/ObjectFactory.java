
package introsde.spotifylayer.soap.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the introsde.spotifylayer.soap.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Artist_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "artist");
    private final static QName _GetRecommendationResponse_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "getRecommendationResponse");
    private final static QName _SearchArtist_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "searchArtist");
    private final static QName _GetRecommendation_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "getRecommendation");
    private final static QName _GetTopTracksByArtist_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "getTopTracksByArtist");
    private final static QName _Song_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "song");
    private final static QName _SearchSongResponse_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "searchSongResponse");
    private final static QName _GetTopTracksByArtistResponse_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "getTopTracksByArtistResponse");
    private final static QName _SearchArtistResponse_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "searchArtistResponse");
    private final static QName _SearchSong_QNAME = new QName("http://ws.soap.spotifylayer.introsde/", "searchSong");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: introsde.spotifylayer.soap.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Song }
     * 
     */
    public Song createSong() {
        return new Song();
    }

    /**
     * Create an instance of {@link Artist }
     * 
     */
    public Artist createArtist() {
        return new Artist();
    }

    /**
     * Create an instance of {@link GetRecommendationResponse }
     * 
     */
    public GetRecommendationResponse createGetRecommendationResponse() {
        return new GetRecommendationResponse();
    }

    /**
     * Create an instance of {@link SearchArtist }
     * 
     */
    public SearchArtist createSearchArtist() {
        return new SearchArtist();
    }

    /**
     * Create an instance of {@link GetRecommendation }
     * 
     */
    public GetRecommendation createGetRecommendation() {
        return new GetRecommendation();
    }

    /**
     * Create an instance of {@link GetTopTracksByArtist }
     * 
     */
    public GetTopTracksByArtist createGetTopTracksByArtist() {
        return new GetTopTracksByArtist();
    }

    /**
     * Create an instance of {@link GetTopTracksByArtistResponse }
     * 
     */
    public GetTopTracksByArtistResponse createGetTopTracksByArtistResponse() {
        return new GetTopTracksByArtistResponse();
    }

    /**
     * Create an instance of {@link SearchArtistResponse }
     * 
     */
    public SearchArtistResponse createSearchArtistResponse() {
        return new SearchArtistResponse();
    }

    /**
     * Create an instance of {@link SearchSong }
     * 
     */
    public SearchSong createSearchSong() {
        return new SearchSong();
    }

    /**
     * Create an instance of {@link SearchSongResponse }
     * 
     */
    public SearchSongResponse createSearchSongResponse() {
        return new SearchSongResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Artist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "artist")
    public JAXBElement<Artist> createArtist(Artist value) {
        return new JAXBElement<Artist>(_Artist_QNAME, Artist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecommendationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "getRecommendationResponse")
    public JAXBElement<GetRecommendationResponse> createGetRecommendationResponse(GetRecommendationResponse value) {
        return new JAXBElement<GetRecommendationResponse>(_GetRecommendationResponse_QNAME, GetRecommendationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchArtist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "searchArtist")
    public JAXBElement<SearchArtist> createSearchArtist(SearchArtist value) {
        return new JAXBElement<SearchArtist>(_SearchArtist_QNAME, SearchArtist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecommendation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "getRecommendation")
    public JAXBElement<GetRecommendation> createGetRecommendation(GetRecommendation value) {
        return new JAXBElement<GetRecommendation>(_GetRecommendation_QNAME, GetRecommendation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTopTracksByArtist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "getTopTracksByArtist")
    public JAXBElement<GetTopTracksByArtist> createGetTopTracksByArtist(GetTopTracksByArtist value) {
        return new JAXBElement<GetTopTracksByArtist>(_GetTopTracksByArtist_QNAME, GetTopTracksByArtist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Song }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "song")
    public JAXBElement<Song> createSong(Song value) {
        return new JAXBElement<Song>(_Song_QNAME, Song.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchSongResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "searchSongResponse")
    public JAXBElement<SearchSongResponse> createSearchSongResponse(SearchSongResponse value) {
        return new JAXBElement<SearchSongResponse>(_SearchSongResponse_QNAME, SearchSongResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTopTracksByArtistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "getTopTracksByArtistResponse")
    public JAXBElement<GetTopTracksByArtistResponse> createGetTopTracksByArtistResponse(GetTopTracksByArtistResponse value) {
        return new JAXBElement<GetTopTracksByArtistResponse>(_GetTopTracksByArtistResponse_QNAME, GetTopTracksByArtistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchArtistResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "searchArtistResponse")
    public JAXBElement<SearchArtistResponse> createSearchArtistResponse(SearchArtistResponse value) {
        return new JAXBElement<SearchArtistResponse>(_SearchArtistResponse_QNAME, SearchArtistResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchSong }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.spotifylayer.introsde/", name = "searchSong")
    public JAXBElement<SearchSong> createSearchSong(SearchSong value) {
        return new JAXBElement<SearchSong>(_SearchSong_QNAME, SearchSong.class, null, value);
    }

}
