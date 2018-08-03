package nx.ESE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nx.ESE.entities.Preferences;

	
	public interface PreferencesRepository extends JpaRepository<Preferences, String>{
		
		
		//@Query("{'user':{'$ref':'user','$id':?0 } }")
		public Preferences findByUserId(String id);
		
		public Preferences findByThemeName(String name);
		

}
