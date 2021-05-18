package ru.itis.xokken.myanimesity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.xokken.myanimesity.models.Person;
import ru.itis.xokken.myanimesity.models.World;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByWorldId (Long id);
    Person findPersonByName (String name);

    @Query(nativeQuery = true, value = "select distinct * from person\n" +
            "inner join accounts_persons on person.id = accounts_persons.person_id\n" +
            "where accounts_persons.account_id=:id")
    @Modifying
    @Transactional
    List<Person> findPersonByUserId(Long id);



}
