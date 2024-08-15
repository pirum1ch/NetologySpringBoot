package ru.netology.netologyspringboot.configurations;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current Profile is Prod";
    }
}
