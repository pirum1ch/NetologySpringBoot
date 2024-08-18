package ru.netology.netologyspringboot.services;

import org.springframework.stereotype.Service;
import ru.netology.netologyspringboot.enums.Authorities;
import ru.netology.netologyspringboot.exceptions.InvalidCredentials;
import ru.netology.netologyspringboot.exceptions.UnauthorizedUser;
import ru.netology.netologyspringboot.repositories.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private UserRepository repository;

    public AuthorizationService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = repository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
