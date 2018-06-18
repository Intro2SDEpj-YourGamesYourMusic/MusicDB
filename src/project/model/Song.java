package project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity  // indicates that this class is an entity to persist in DB
@Table(name="Song") // to whate table must be persisted
@NamedQuery(name="Song.findAll", query="SELECT s FROM Song s")
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id // defines this attributed as the one that identifies the entity
    @Column(name="idSong") // maps the following attribute to a column
    private String idSong;
    @Column(name="name")
    private String name;
    @Column(name="artistName")
    private String artistName;
    // mappedBy must be equal to the name of the attribute in LifeStatus that maps this relation
    @OneToMany(mappedBy="song",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<User_likes> user_likes;
	public String getIdSong() {
		return idSong;
	}
	public void setIdSong(String idSong) {
		this.idSong = idSong;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public List<User_likes> getUser_likes() {
		return user_likes;
	}
	public void setUser_likes(List<User_likes> user_likes) {
		this.user_likes = user_likes;
	}
}