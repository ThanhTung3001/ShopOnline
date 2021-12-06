package com.example.springweb.Controller;

import com.example.springweb.Service.imp.UserService;
import com.example.springweb.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

      @Autowired
      UserService userService;

    @GetMapping(value = "/user")
    public String userInformation(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByName(auth.getName());
        model.addAttribute("UserModel",userDto);
        return "User";
    }
}
