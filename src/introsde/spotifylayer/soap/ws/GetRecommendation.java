
package introsde.spotifylayer.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per getRecommendation complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="getRecommendation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="artistSeeds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="songSeeds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRecommendation", propOrder = {
    "artistSeeds",
    "songSeeds"
})
public class GetRecommendation {

    protected String artistSeeds;
    protected String songSeeds;

    /**
     * Recupera il valore della proprieta' artistSeeds.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArtistSeeds() {
        return artistSeeds;
    }

    /**
     * Imposta il valore della proprieta' artistSeeds.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArtistSeeds(String value) {
        this.artistSeeds = value;
    }

    /**
     * Recupera il valore della proprieta' songSeeds.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSongSeeds() {
        return songSeeds;
    }

    /**
     * Imposta il valore della proprieta' songSeeds.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSongSeeds(String value) {
        this.songSeeds = value;
    }

}
