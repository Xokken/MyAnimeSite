package ru.itis.xokken.myanimesity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserForm {
    private String name;
    private String email;
    private String password1;
    private String password2;
    private int age;
}
