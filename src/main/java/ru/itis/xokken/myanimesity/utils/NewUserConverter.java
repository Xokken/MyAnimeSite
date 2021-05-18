package ru.itis.xokken.myanimesity.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.xokken.myanimesity.models.User;

@Component
public class NewUserConverter implements Converter<String, User> {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User convert(String source) {
        String[] data = source.split(",");
        return User.builder()
                .email(data[0])
                .name(data[1])
                .age(Integer.parseInt(data[2]))
                .hashPassword(passwordEncoder.encode(data[3]))
                .role(User.Role.USER)
                .img("/hostImg/default.jpg")
                .build();
    }
}
