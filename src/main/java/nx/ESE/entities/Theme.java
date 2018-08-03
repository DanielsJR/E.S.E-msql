package nx.ESE.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

//@Entity
@Embeddable
public class Theme {
	
	/*@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	public String getId() {
		return id;
	}*/

	@Column(name = "theme_name")
	private String name;
	
	@Column(name = "theme_isDark")
	private boolean isDark;
	
	@Column(name = "theme_color")
	private String color;
	
	public Theme() {
		super();
	}
	

	public Theme(String name, boolean isDark, String color) {
		super();
		this.name = name;
		this.isDark = isDark;
		this.color = color;
	}
	
	



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsDark() {
		return isDark;
	}

	public void setIsDark(boolean isDark) {
		this.isDark = isDark;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Theme other = (Theme) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Theme [name=" + name + ", isDark=" + isDark + ", color=" + color + "]";
	}

	


}
