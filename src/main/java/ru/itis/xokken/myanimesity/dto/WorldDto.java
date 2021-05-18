package ru.itis.xokken.myanimesity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.xokken.myanimesity.models.World;
import ru.itis.xokken.myanimesity.services.WorldServiceImpl;

import java.util.List;
import java.util.stream.Collectors;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorldDto {
    private Long id;
    private String name;
    private String img;
    private List<PersonDto> personDtos;

    public static WorldDto from (World world){
        return WorldDto.builder()
                .id(world.getId())
                .img(world.getImg())
                .name(world.getName())
                .personDtos(PersonDto.from(world.getPersons()))
                .build();
    }

    public static List<WorldDto> from (List<World> worlds){
        return worlds.stream().map(WorldDto::from).collect(Collectors.toList());
    }
}
