package com.test.controller;

import com.test.pojo.Dic;
import com.test.pojo.User;
import com.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
