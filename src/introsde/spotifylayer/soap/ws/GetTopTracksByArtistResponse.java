
package introsde.spotifylayer.soap.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per getTopTracksByArtistResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="getTopTracksByArtistResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="songs" type="{http://ws.soap.spotifylayer.introsde/}song" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTopTracksByArtistResponse", propOrder = {
    "songs"
})
public class GetTopTracksByArtistResponse {

    protected List<Song> songs;

    /**
     * Gets the value of the songs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the songs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSongs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Song }
     * 
     * 
     */
    public List<Song> getSongs() {
        if (songs == null) {
            songs = new ArrayList<Song>();
        }
        return this.songs;
    }

}
