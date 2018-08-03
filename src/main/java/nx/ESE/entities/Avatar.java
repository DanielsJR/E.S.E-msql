package nx.ESE.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

//@Entity
@Embeddable
public class Avatar {
	
	/*@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	
	private String id;
		public String getId() {
		return id;
	}*/

	@Column(name = "avatar_name")
	private String name;
    
	@Column(name = "avatar_type")
	private String type;
	
	@Column(name = "avatar_data")
	private String data;

	public static final String SERVER_AVATAR_PATH = "C:\\ESE\\users\\images\\";

	public Avatar() {
		super();
	}

	public Avatar(String name, String type, String data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}
	
	



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Avatar [name=" + name + ", type=" + type + "]";
	}




}
