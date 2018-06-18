
package introsde.spotifylayer.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per searchSongResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="searchSongResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="song" type="{http://ws.soap.spotifylayer.introsde/}song" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchSongResponse", propOrder = {
    "song"
})
public class SearchSongResponse {

    protected Song song;

    /**
     * Recupera il valore della proprieta' song.
     * 
     * @return
     *     possible object is
     *     {@link Song }
     *     
     */
    public Song getSong() {
        return song;
    }

    /**
     * Imposta il valore della proprieta' song.
     * 
     * @param value
     *     allowed object is
     *     {@link Song }
     *     
     */
    public void setSong(Song value) {
        this.song = value;
    }

}
