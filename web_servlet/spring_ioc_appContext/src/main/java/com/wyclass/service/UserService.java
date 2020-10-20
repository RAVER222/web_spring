package com.wyclass.service;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private  MailService mailService;

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    private List<User> users =new ArrayList<>(List.of(
            new User(1, "bob@example.com", "password", "Bob"), // bob
            new User(2, "alice@example.com", "password", "Alice"), // alice
            new User(3, "tom@example.com", "password", "Tom"))); // tom

    public User login(String email ,String password)
    {
        for (User user : users) {
            if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password))
            {
                mailService.sendLoginMail(user);
                return  user;
            }
        }
        throw  new RuntimeException("login failed");
    }


    public User register(String email,String password,String name)
    {
        users.forEach((user)->{
            if(user.getEmail().equalsIgnoreCase(email)){
                throw  new RuntimeException("email exist");
            }
        });
        User user = new User(users.stream().mapToLong(u -> u.getId()).max().getAsLong(), email, password, name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return  user;
    }



}
