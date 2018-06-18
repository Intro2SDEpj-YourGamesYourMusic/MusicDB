
package introsde.spotifylayer.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per getTopTracksByArtist complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="getTopTracksByArtist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="artistId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getTopTracksByArtist", propOrder = {
    "artistId"
})
public class GetTopTracksByArtist {

    protected String artistId;

    /**
     * Recupera il valore della proprieta' artistId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtistId() {
        return artistId;
    }

    /**
     * Imposta il valore della proprieta' artistId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtistId(String value) {
        this.artistId = value;
    }

}
