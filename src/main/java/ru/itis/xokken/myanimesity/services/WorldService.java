package ru.itis.xokken.myanimesity.services;

import ru.itis.xokken.myanimesity.dto.WorldDto;
import ru.itis.xokken.myanimesity.models.Person;
import ru.itis.xokken.myanimesity.models.World;

import java.util.List;

public interface WorldService {
    List<WorldDto> getWorlds();
    List<Person> getPersonsOfWorld(WorldDto worldDto);
    WorldDto getWorldByName(String name);
    WorldDto updateWorld(Long id, WorldDto  worldDto);

    WorldDto addWorld(WorldDto worldDto);

    void deleteWorld(Long id);
}
