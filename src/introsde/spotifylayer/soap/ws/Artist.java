
package introsde.spotifylayer.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per artist complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="artist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="idArtist" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "artist", propOrder = {
    "name"
})
public class Artist {

    protected String name;
    @XmlAttribute(name = "idArtist")
    protected String idArtist;

    /**
     * Recupera il valore della proprieta' name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprieta' name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Recupera il valore della proprieta' idArtist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdArtist() {
        return idArtist;
    }

    /**
     * Imposta il valore della proprieta' idArtist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdArtist(String value) {
        this.idArtist = value;
    }

}
