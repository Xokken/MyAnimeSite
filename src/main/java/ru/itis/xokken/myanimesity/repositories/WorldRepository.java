package ru.itis.xokken.myanimesity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.xokken.myanimesity.models.Person;
import ru.itis.xokken.myanimesity.models.World;

import java.util.List;


public interface WorldRepository extends JpaRepository<World, Long> {
    World findByName (String name);
}
