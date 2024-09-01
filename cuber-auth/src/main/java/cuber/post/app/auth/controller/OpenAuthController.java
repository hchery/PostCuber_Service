package cuber.post.app.auth.controller;

import cuber.post.app.auth.http.*;
import cuber.post.app.auth.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DATE: 2024/8/30
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@RequestMapping("/api/auth/open")
@RestController
public class OpenAuthController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        return loginService.doLogin(request);
    }
}
