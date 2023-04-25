package br.com.erudio.restwhitspringbootandjavaerudio.repository;

import br.com.erudio.restwhitspringbootandjavaerudio.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
