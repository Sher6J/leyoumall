package com.leyou.user.api;

import com.leyou.user.pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sher6j
 * @create 2020-05-01-17:25
 */
public interface UserApi {

    @GetMapping("query")
    public User queryUser(
            @RequestParam("username")String username,
            @RequestParam("password")String password);
}
