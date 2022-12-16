package com.testproject.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testproject.demo.bean.GeneralProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class UsersController {
    private GeneralProperties generalProperties;
    private Integer id;
    private String firstname;
    private String lastname;
    private String avatar;
    private String email;
    private String phoneNumber;
    private String city;
    private String country;
    private String createdAt;

    public UsersController(GeneralProperties generalProperties) {
        this.generalProperties = generalProperties;
    }

    @GetMapping(value = "/users")
    private String getUsersToAPI (Model model) {
        String uri = generalProperties.getApiUri();
        RestTemplate restTemplate = new RestTemplate();
        String usersStr = restTemplate.getForObject(uri, String.class);

        try {
            List<UsersController> users = new ObjectMapper().readValue(usersStr, List.class);
            model.addAttribute("usersData", users);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return "users";
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
