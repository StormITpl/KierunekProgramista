package pl.stormit.usermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.stormit.usermanager.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}