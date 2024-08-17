package ru.netology.netologyspringboot.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.netology.netologyspringboot.enums.Authorities;
import ru.netology.netologyspringboot.services.AuthorizationService;

import java.util.List;


@Controller
@RequestMapping("/")
@Log4j2
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @PostMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        log.log(Level.INFO, "Получаем разрешения для пользователя ${user}", user);
        return service.getAuthorities(user, password);
    }

    @GetMapping("/authorize")
    public String signIn (){
        return "/signin.html";
    }

    @GetMapping
    public String mainPage (){
        return "/mainPage.html";
    }

}
