package ru.itis.xokken.myanimesity.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.xokken.myanimesity.api.AnimeApi;
import ru.itis.xokken.myanimesity.api.entity.QuoteResponse;
import ru.itis.xokken.myanimesity.dto.UserDto;
import ru.itis.xokken.myanimesity.dto.WorldDto;
import ru.itis.xokken.myanimesity.services.UserService;
import ru.itis.xokken.myanimesity.services.WorldService;
import ru.itis.xokken.myanimesity.utils.OutstandingUser;

import java.util.List;


@Controller
@Slf4j
public class MainController {

    @Autowired
    private WorldService worldService;
    @Autowired
    private UserService userService;

    @GetMapping("/main")
    public String getMainPage(Model model){
        List<WorldDto> worlds = worldService.getWorlds();
        log.info(worlds.toString());
        model.addAttribute("worldList", worlds);
        String currentPrincipalName = OutstandingUser.getUserName();
        UserDto userDto = userService.getUserByEmail(currentPrincipalName);
        log.info(userDto.toString());
        model.addAttribute("user", userDto);
        return "main";
    }

}
