package ru.itis.xokken.myanimesity.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.xokken.myanimesity.config.AppConfig;
import ru.itis.xokken.myanimesity.dto.EquipmentDto;
import ru.itis.xokken.myanimesity.dto.UserDto;
import ru.itis.xokken.myanimesity.models.Equipment;
import ru.itis.xokken.myanimesity.repositories.EquipmentRepository;
import ru.itis.xokken.myanimesity.services.UserServiceImpl;
import ru.itis.xokken.myanimesity.utils.OutstandingUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.*;

@Controller
public class UploadController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/upload")
    public String uploadFiles(HttpServletRequest request) throws IOException, ServletException {
        String path = "C:\\Users\\Xokken\\IdeaProjects\\hostImgSem\\hostImg\\";
        Part filePart = request.getPart("file");
        String currentPrincipalName = OutstandingUser.getUserName();

        OutputStream out;
        InputStream filecontent;

        out = new FileOutputStream(path + File.separator + currentPrincipalName + ".jpg");
        filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }

        UserDto userDto = userService.getUserByEmail(currentPrincipalName);
        userService.updateImg(userDto, "/hostImg/" + currentPrincipalName + ".jpg");
        userDto.setImg("/hostImg/" + currentPrincipalName + ".jpg");
        return "redirect:/profile";

    }

    @GetMapping("/uploadError")
    public String uploadFilesError(HttpServletRequest request) throws IOException{
        String path = "C:\\Users\\Xokken\\IdeaProjects\\hostImgSem\\hostImg\\hostImg\\hostImg";
        OutputStream out = new FileOutputStream(path);
        return "test";

    }

}
