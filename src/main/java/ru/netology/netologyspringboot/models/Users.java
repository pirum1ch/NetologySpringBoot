package ru.netology.netologyspringboot.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

@Getter
public class Users {

    @Size(min = 3, max = 10)
    @NotBlank
    private final String password;

    @Size(min = 2, max = 20)
    @NotBlank
    private final String login;

    public Users(String password, String login) {
        this.password = password;
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(password, users.password) && Objects.equals(login, users.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, login);
    }

    @Override
    public String toString() {
        return "User login: " + login
                + " and User password: " + password;
    }
}
