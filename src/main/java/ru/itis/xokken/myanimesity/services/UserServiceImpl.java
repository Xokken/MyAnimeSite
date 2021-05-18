package ru.itis.xokken.myanimesity.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.xokken.myanimesity.dto.NewUserForm;
import ru.itis.xokken.myanimesity.dto.PersonDto;
import ru.itis.xokken.myanimesity.dto.UserDto;
import ru.itis.xokken.myanimesity.dto.UserForm;
import ru.itis.xokken.myanimesity.models.Person;
import ru.itis.xokken.myanimesity.models.User;
import ru.itis.xokken.myanimesity.repositories.PersonRepository;
import ru.itis.xokken.myanimesity.repositories.UserRepository;

import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    @Qualifier(value = "MyConversionService")
    private ConversionService conversionService;

    @Override
    public void addNewUser(NewUserForm userForm) {
        String source = userForm.getEmail() + "," + userForm.getName() + "," + userForm.getAge() + "," + userForm.getPassword1();
        System.out.println(source);
        User user = conversionService.convert(source, User.class);
        userRepository.save(user);
    }

    @Override
    public void addPersonToUser(String personDto, String email) {
        Person person = personRepository.findPersonByName(personDto);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userRepository.addPersonToUser(user.getId(), person.getId());

    }

    @Override
    public void updateImg(UserDto userDto, String img) {
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        userRepository.updateImg(user.getId(), img);
    }

    @Override
    public void deletePersonToUser(PersonDto personDto, String email) {
        log.info("SASASSASASASASSAS");
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        log.info(personDto.toString() + "@@@@" + user.toString());
        userRepository.deletePersonToUser(user.getId(), personDto.getId());
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserDto userDto = UserDto.from(user);
        return userDto;
    }

    @Override
    public List<PersonDto> getPersonsByUsers(UserDto userDto) {
        List<PersonDto> personList = PersonDto.from(personRepository.findPersonByUserId(userDto.getId()));
        log.info(personList.toString());
        return personList;

    }

}
