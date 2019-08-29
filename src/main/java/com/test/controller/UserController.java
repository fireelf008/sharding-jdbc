package com.test.controller;

import com.test.pojo.Dic;
import com.test.pojo.User;
import com.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "user", description = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "save-dic")
    @ApiOperation(value = "save-dic" , notes = "save-dic")
    public ResponseEntity<Void> saveDic(@ApiParam(name = "dic", value = "传入json对象", required = true) @RequestBody Dic dic) {
        this.userService.saveDic(dic);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "save-user")
    @ApiOperation(value = "save-user" , notes = "save-user")
    public ResponseEntity<Void> saveUser(@ApiParam(name = "user", value = "传入json对象", required = true) @RequestBody User user) {
        this.userService.save(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "find-user-by-page")
    @ApiOperation(value = "find-user-by-page" , notes = "find-user-by-page")
    public ResponseEntity<Page<User>> findByPage(@ApiParam(name = "page", value = "页数") @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                 @ApiParam(name = "size", value = "条数") @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        Page<User> userPage = this.userService.findUserByPage(page, size);
        return Optional.ofNullable(userPage).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
