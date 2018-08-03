package nx.ESE.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import nx.ESE.entities.Avatar;
import nx.ESE.entities.Gender;
import nx.ESE.entities.Role;
import nx.ESE.entities.User;
import nx.ESE.repositories.CourseRepository;
import nx.ESE.repositories.PreferencesRepository;
import nx.ESE.repositories.SubjectRepository;
import nx.ESE.repositories.UserRepository;

@Service
public class DatabaseSeederService {

	@Value("${nx.admin.username}")
	private String username;

	@Value("${nx.admin.password}")
	private String password;

	@Value("${nx.databaseSeeder.ymlFileName:#{null}}")
	private Optional<String> ymlFileName;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PreferencesRepository preferencesRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(DatabaseSeederService.class);

	@PostConstruct
	public void seedDatabase() {
		if (ymlFileName.isPresent()) {
			this.deleteAllAndCreateAdmin();
			try {
				this.seedDatabase(ymlFileName.get());
			} catch (IOException e) {
				logger.error("File " + ymlFileName + " doesn't exist or can't be opened");
			}
		} else {
			this.createAdminIfNotExist();
		}
	}

	public void seedDatabase(String ymlFileName) throws IOException {
		assert ymlFileName != null && !ymlFileName.isEmpty();
		Yaml yamlParser = new Yaml(new Constructor(DatabaseGraph.class));
		InputStream input = new ClassPathResource(ymlFileName).getInputStream();
		DatabaseGraph dbGraph = (DatabaseGraph) yamlParser.load(input);

		// Save Repositories
		if (dbGraph.getUserList() != null) {
			this.userRepository.saveAll(dbGraph.getUserList());
		}
		
		if (dbGraph.getPreferencesList() != null) {
			this.preferencesRepository.saveAll(dbGraph.getPreferencesList());
		}
		
		if (dbGraph.getCoursesList() != null) {
			this.courseRepository.saveAll(dbGraph.getCoursesList());
		}
		
		if (dbGraph.getSubjectsList() != null) {
			this.subjectRepository.saveAll(dbGraph.getSubjectsList());
		}

		logger.warn("------------------------- Seed: " + ymlFileName + "-----------");
	}

	public void deleteAllAndCreateAdmin() {
		logger.warn("------------------------- delete All And Create Admin-----------");
		// Delete Repositories
		this.userRepository.deleteAll();
		this.preferencesRepository.deleteAll();
		this.createAdminIfNotExist();
	}

	public void createAdminIfNotExist() {
		logger.warn("------------------------- createAdminIfNotExist()-----------");
		if (this.userRepository.findByUsername(this.username) == null) {
			User user = new User(this.username, this.password);
			user.setFirstName("Daniel Jesús");
			user.setLastName("Rubio Parra");
			user.setGender(Gender.HOMBRE);
			user.setAvatar(new Avatar("admin.png", "image/png", Avatar.SERVER_AVATAR_PATH + "admin.png"));
			user.setRoles(new Role[] { Role.ADMIN, Role.MANAGER });
			this.userRepository.save(user);
		}
	}

}
