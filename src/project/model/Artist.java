package project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity  // indicates that this class is an entity to persist in DB
@Table(name="Artist") // to whate table must be persisted
@NamedQuery(name="Artist.findAll", query="SELECT a FROM Artist a")
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id // defines this attributed as the one that identifies the entity
    @Column(name="idArtist") // maps the following attribute to a column
    private String idArtist;
    @Column(name="name")
    private String name;
    // mappedBy must be equal to the name of the attribute in LifeStatus that maps this relation
    @OneToMany(mappedBy="artist",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<User_likes> user_likes;
    
	public String getIdArtist() {
		return idArtist;
	}
	public void setIdArtist(String idArtist) {
		this.idArtist = idArtist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User_likes> getUser_likes() {
		return user_likes;
	}
	public void setUser_likes(List<User_likes> user_likes) {
		this.user_likes = user_likes;
	}
    
    
       
}