package nx.ESE.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nx.ESE.dtos.UserDto;
import nx.ESE.dtos.UserMinDto;
import nx.ESE.entities.Role;
import nx.ESE.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByUsername(String username);
	
	public User findByDni(String dni);
	
	public User findByMobile(String mobile);
	
	public User findByEmail(String email);
	
	public User findByRoles(Role[]  roles);
	

	@Query("select u.username from User u where u.roles like ?1")
	public List<UserMinDto> findUsersAll(Role role);
	
	@Query("select u from User u join u.roles ur where ur like ?1")
	public List<UserDto> findUsersFullAll(Role role);

}
