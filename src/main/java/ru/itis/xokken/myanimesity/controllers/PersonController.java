package ru.itis.xokken.myanimesity.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.xokken.myanimesity.config.AppConfig;
import ru.itis.xokken.myanimesity.dto.PersonDto;
import ru.itis.xokken.myanimesity.dto.WorldDto;
import ru.itis.xokken.myanimesity.services.UserService;
import ru.itis.xokken.myanimesity.services.WorldService;
import ru.itis.xokken.myanimesity.utils.OutstandingUser;

import java.util.List;


@Controller
@Slf4j
public class PersonController {

    @Autowired
    private WorldService worldService;
    @Autowired
    private UserService userService;

    @GetMapping("/persons")
    public String getPersonsPage(String worldName, Model model){
        String currentPrincipalName = OutstandingUser.getUserName();
        log.info(currentPrincipalName + "$$$$$$$$$$$$$$$$$$$$");
        log.info(worldName + " ####################");
        WorldDto worldDto = WorldDto.builder()
                .name(worldName)
                .build();
        log.info("++++++++++++++++++");
        List<PersonDto> personDtos = PersonDto.from(worldService.getPersonsOfWorld(worldDto));
        log.info(personDtos.toString());
        model.addAttribute("personList", personDtos);
        return "persons";
    }

    @PostMapping("/persons")
    public String addGirls(PersonDto personDto, Boolean tag){
        log.info(personDto.toString() + "CCCCCCCCCCCCCCCC");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        if (tag == null){
            return "redirect:persons?worldName=" + personDto.getWorld();
        }
        else if (tag) {
            userService.addPersonToUser(personDto.getName(), currentPrincipalName);
        } else {
            userService.deletePersonToUser(personDto, currentPrincipalName);
        }
        return "redirect:persons?worldName=" + personDto.getWorld();

    }

}
