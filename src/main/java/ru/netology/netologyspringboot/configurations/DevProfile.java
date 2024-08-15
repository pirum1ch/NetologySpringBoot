package ru.netology.netologyspringboot.configurations;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current Porfile is DEV";
    }
}
