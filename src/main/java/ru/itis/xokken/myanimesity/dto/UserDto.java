package ru.itis.xokken.myanimesity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.xokken.myanimesity.models.User;

import java.util.List;
import java.util.stream.Collectors;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String img;

    public static UserDto from (User user){
        return UserDto.builder()
                .id(user.getId())
                .img(user.getImg())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .build();
    }

    public static List<UserDto> from (List<User> persons){
        return persons.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
