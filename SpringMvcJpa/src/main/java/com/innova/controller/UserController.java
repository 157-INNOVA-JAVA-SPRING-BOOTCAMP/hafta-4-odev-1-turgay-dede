package com.innova.controller;

import com.innova.dto.UserRegisterDto;
import com.innova.entity.UserEntity;
import com.innova.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@Log4j2
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("key_register", new UserRegisterDto());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("key_register") UserRegisterDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Hata var!");
            return "register";
        }
        UserEntity user = new UserEntity();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setCreatedDate(LocalDate.now());

        userRepository.save(user);
        return "success";
    }

    @GetMapping("/getall")
    public String getAllUsers(Model model) {
        List<UserEntity> users = (List<UserEntity>) this.userRepository.findAll();
        model.addAttribute("user_list",users);
        return "user-list";
    }

    @GetMapping("/getall/responsebody")
    @ResponseBody
    public List<UserEntity> getAllUsers2() {
        return  (List<UserEntity>) this.userRepository.findAll();
    }
}
