package my.mood.ExpenceTracker.Expence_Tracker.Expence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenceRepository extends JpaRepository<Expence_Entity, Integer>{

	List<Expence_Entity> findByCategory(String category);

}
