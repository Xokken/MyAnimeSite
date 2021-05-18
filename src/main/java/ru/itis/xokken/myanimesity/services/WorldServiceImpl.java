package ru.itis.xokken.myanimesity.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.xokken.myanimesity.dto.WorldDto;
import ru.itis.xokken.myanimesity.models.Person;
import ru.itis.xokken.myanimesity.models.World;
import ru.itis.xokken.myanimesity.repositories.PersonRepository;
import ru.itis.xokken.myanimesity.repositories.WorldRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorldServiceImpl implements WorldService {
    @Autowired
    private WorldRepository worldRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<WorldDto> getWorlds() {
        return WorldDto.from(worldRepository.findAll());
    }

    @Override
    public List<Person> getPersonsOfWorld(WorldDto worldDto) {
        World world = worldRepository.findByName(worldDto.getName());
        return personRepository.findAllByWorldId(world.getId());
    }

    @Override
    public WorldDto getWorldByName(String name) {
        return WorldDto.from(worldRepository.findByName(name));
    }

    @Override
    public WorldDto addWorld(WorldDto worldDto) {
        worldRepository.save(getWorld(worldDto));
        worldDto.setId(worldRepository.findByName(worldDto.getName()).getId());
        return worldDto;
    }

    @Override
    public WorldDto updateWorld(Long id, WorldDto worldDto) {
        World world = worldRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("World not found"));
        world.setName(worldDto.getName());
        world.setImg(world.getImg());
        worldRepository.save(world);
        worldDto.setId(id);
        return worldDto;
    }

    @Override
    public void deleteWorld(Long id) {
        worldRepository.deleteById(id);
    }

    private World getWorld(WorldDto worldDto){
        World world = World.builder()
                .name(worldDto.getName())
                .img(worldDto.getImg())
                .persons(Collections.EMPTY_LIST)
                .build();
        return world;
    }
}
