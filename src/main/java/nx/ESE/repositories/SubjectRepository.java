package nx.ESE.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import nx.ESE.entities.core.Subject;

public interface SubjectRepository extends JpaRepository<Subject, String> {
	

}
