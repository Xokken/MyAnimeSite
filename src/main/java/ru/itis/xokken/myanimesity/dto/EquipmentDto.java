package ru.itis.xokken.myanimesity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.xokken.myanimesity.models.Equipment;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipmentDto {
    private Long id;
    private String type;
    private String name;

    public static EquipmentDto from (Equipment equipment){
        return EquipmentDto.builder()
                .id(equipment.getId())
                .name(equipment.getName())
                .type(equipment.getType())
                .build();
    }

    public static List<EquipmentDto> from (List<Equipment> persons){
        return persons.stream().map(EquipmentDto::from).collect(Collectors.toList());
    }

}
