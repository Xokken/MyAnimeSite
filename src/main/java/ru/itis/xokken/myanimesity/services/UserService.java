package ru.itis.xokken.myanimesity.services;

import ru.itis.xokken.myanimesity.dto.NewUserForm;
import ru.itis.xokken.myanimesity.dto.PersonDto;
import ru.itis.xokken.myanimesity.dto.UserDto;
import ru.itis.xokken.myanimesity.dto.UserForm;

import java.util.List;

public interface UserService {
    void addNewUser(NewUserForm userForm);
    void addPersonToUser(String personDto, String email);
    void deletePersonToUser(PersonDto personDto, String email);
    UserDto getUserByEmail(String email);

    void updateImg(UserDto userDto, String img);

    List<PersonDto> getPersonsByUsers(UserDto userDto);
}
