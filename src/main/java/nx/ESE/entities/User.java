package nx.ESE.entities;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column(unique = true)
	private String username;

	private String password;

	private String firstName;

	private String lastName;

	@Column(unique = true)
	private String dni;

	private Date birthday;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Gender gender;

	//@OneToOne
	@Embedded
	private Avatar avatar;

	@Column(unique = true)
	private String mobile;

	@Column(unique = true)
	private String email;

	private String address;

	@Enumerated(EnumType.STRING)
	@Column(length = 30)
	private Commune commune;

	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_roles")
	@OrderColumn (name = "index_roles")
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role[] roles;

	private boolean active;

	private Date createdAt;

	public User() {
		active = true;
		createdAt = new Date();
	}

	public User(String username, String password, String firstName, String lastName, String dni, Date birthday,
			Gender gender, Avatar avatar, String mobile, String email, String address, Commune commune) {
		this();
		this.username = username;
		this.setPassword(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.birthday = birthday;
		this.gender = gender;
		this.avatar = avatar;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.commune = commune;
		this.roles = new Role[] { Role.STUDENT };
	}

	public User(String username, String password) {
		this(username, password, null, null, null, null, null, null, null, null, null, null);

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public Role[] getRoles() {
		return roles;
	}

	public void setRoles(Role[] roles) {
		this.roles = roles;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		String birthdayF = "null";
		if (this.birthday != null) {
			birthdayF = new SimpleDateFormat("dd-MMM-yyyy").format(birthday.getTime());
		}
		String date = "null";
		if (createdAt != null) {
			date = new SimpleDateFormat("dd-MMM-yyyy").format(createdAt.getTime());
		}
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dni=" + dni + ", birthday=" + birthdayF + ", gender=" + gender
				+ ", mobile=" + mobile + ", avatar=" + avatar + ", email=" + email + ", address=" + address
				+ ", commune=" + commune + ", roles=" + Arrays.toString(roles) + ", active=" + active + ", createdAt="
				+ date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}