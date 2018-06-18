
package introsde.spotifylayer.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per searchSong complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="searchSong">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="songName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchSong", propOrder = {
    "songName"
})
public class SearchSong {

    protected String songName;

    /**
     * Recupera il valore della proprieta' songName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Imposta il valore della proprieta' songName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSongName(String value) {
        this.songName = value;
    }

}
