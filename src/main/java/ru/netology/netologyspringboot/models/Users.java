package ru.netology.netologyspringboot.models;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Users {

    private final String password;

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
