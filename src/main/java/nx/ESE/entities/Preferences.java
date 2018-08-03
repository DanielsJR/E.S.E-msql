package nx.ESE.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Preferences {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	
	@OneToOne//(cascade = CascadeType.ALL)
	private User user;

	//@ManyToOne
	@Embedded
	private Theme theme;

	public Preferences() {
		super();
	}
	
	
	public Preferences(User user, Theme theme) {
		super();
		this.user = user;
		this.theme = theme;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

}
