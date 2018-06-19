package project.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity  // indicates that this class is an entity to persist in DB
@Table(name="User_likes") // to whate table must be persisted
@NamedQuery(name="User_likes.findAll", query="SELECT ul FROM User_likes ul")
public class User_likes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // defines this attributed as the one that identifies the entity
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name="idRelation") // maps the following attribute to a column
    private int idRelation;

    @ManyToOne
    @JoinColumn(name="id",referencedColumnName="id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="idArtist",referencedColumnName="idArtist")
    private Artist artist;
    
    @ManyToOne
    @JoinColumn(name="idSong",referencedColumnName="idSong")
    private Song song;
    
    @Column(name="rating")
    private boolean rating;

	public int getIdRelation() {
		return idRelation;
	}

	public void setIdRelation(int idRelation) {
		this.idRelation = idRelation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public boolean isRating() {
		return rating;
	}

	public void setRating(boolean rating) {
		this.rating = rating;
	}

    
}
