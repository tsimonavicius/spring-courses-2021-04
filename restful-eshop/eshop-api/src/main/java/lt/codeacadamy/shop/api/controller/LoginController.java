package lt.codeacadamy.shop.api.controller;

import lt.codeacadamy.shop.api.dto.LoggedInUserDto;
import lt.codeacadamy.shop.api.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public LoggedInUserDto login(@AuthenticationPrincipal User user) {

        return new LoggedInUserDto(user);
    }
}
