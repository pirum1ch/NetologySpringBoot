package ru.netology.netologyspringboot.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.netologyspringboot.enums.Authorities;
import ru.netology.netologyspringboot.models.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<Users, Authorities> roles = new HashMap<>();

    public UserRepository() {
        roles.put(new Users("111", "Ivan"), Authorities.READ);
        roles.put(new Users("444", "Olya"), Authorities.WRITE);
        roles.put(new Users("222", "Igor"), Authorities.DELETE);
        roles.put(new Users("333", "Maks"), Authorities.WRITE);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> list = new ArrayList<>();
        Users checkedUser = new Users(password,user);
        for(Map.Entry<Users, Authorities> entry : roles.entrySet()){
            if(entry.getKey().equals(checkedUser)){
                list.add(entry.getValue());
            }
        }
        return list;
    }
}
