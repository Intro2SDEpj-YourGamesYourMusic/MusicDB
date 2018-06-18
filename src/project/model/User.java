package project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity  // indicates that this class is an entity to persist in DB
@Table(name="User") // to whate table must be persisted
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id // defines this attributed as the one that identifies the entity
    @Column(name="id") // maps the following attribute to a column
    private String id;
 // mappedBy must be equal to the name of the attribute in LifeStatus that maps this relation
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<User_likes> user_likes;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<User_likes> getUser_likes() {
		return user_likes;
	}
	public void setUser_likes(List<User_likes> user_likes) {
		this.user_likes = user_likes;
	}
}