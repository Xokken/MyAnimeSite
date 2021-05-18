package ru.itis.xokken.myanimesity.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.xokken.myanimesity.api.AnimeApi;
import ru.itis.xokken.myanimesity.api.entity.QuoteResponse;
import ru.itis.xokken.myanimesity.dto.PersonDto;
import ru.itis.xokken.myanimesity.dto.UserDto;
import ru.itis.xokken.myanimesity.services.UserService;
import ru.itis.xokken.myanimesity.utils.OutstandingUser;

import java.util.List;

@Controller
@Slf4j
public class ProfileController {

    @Autowired
    AnimeApi animeApi;

    @Autowired
    UserService userService;

    @GetMapping("/profile")
    public String getProfilePage(Model model){
        String currentPrincipalName = OutstandingUser.getUserName();
        UserDto userDto = userService.getUserByEmail(currentPrincipalName);
        model.addAttribute("user", userDto);
        List<PersonDto> personDtoList = userService.getPersonsByUsers(userDto);
        model.addAttribute("personList", personDtoList);
        QuoteResponse quote = animeApi.getQuoteResponse();
        model.addAttribute("quote", quote);
        log.info(personDtoList.toString());
        return "profile";
    }

    @PostMapping("/profile")
    public String addGirls(PersonDto personDto){
        System.out.println(personDto.toString());
        String currentPrincipalName = OutstandingUser.getUserName();
        userService.deletePersonToUser(personDto, currentPrincipalName);
        return "redirect:profile";

    }
}
