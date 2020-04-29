package com.leyou.user.controller;

import com.leyou.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sher6j
 * @create 2020-04-29-21:11
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户数据的校验，包括对：手机号、用户名的唯一性校验。
     * @param data 用户名或手机号
     * @param type 1-用户名 2-手机号
     * @return
     */
    @GetMapping("/check/{data}/{type}")
    public ResponseEntity<Boolean> checkUser(
            @PathVariable("data")String data,
            @PathVariable("type")Integer type) {

        Boolean bool = this.userService.checkUser(data, type);
        if (bool == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bool);
    }
}
