package ru.itis.xokken.myanimesity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.xokken.myanimesity.models.Equipment;
import ru.itis.xokken.myanimesity.models.Person;
import ru.itis.xokken.myanimesity.models.World;
import ru.itis.xokken.myanimesity.services.WorldServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDto {
    private Long id;
    private String name;
    private String img;
    private String world;
    private EquipmentDto equipment;

    public static PersonDto from (Person person){
        return PersonDto.builder()
                .id(person.getId())
                .img(person.getImg())
                .name(person.getName())
                .world(person.getWorld().getName())
                .equipment(EquipmentDto.from(person.getEquipment()))
                .build();
    }

    public static List<PersonDto> from (List<Person> persons){
        return persons.stream().map(PersonDto::from).collect(Collectors.toList());
    }
}
