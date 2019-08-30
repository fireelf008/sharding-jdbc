package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.pojo.Dic;
import com.test.pojo.User;
import com.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Api(tags = "user", description = "user")
@Slf4j
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

    @GetMapping(value = "find-user-by-id")
    @ApiOperation(value = "find-user-by-id" , notes = "find-user-by-id")
    public ResponseEntity<User> findUserById(@ApiParam(name = "id", value = "id") @RequestParam(name = "id", required = false, defaultValue = "0") Long id) {
        User user = this.userService.findById(id);
        return Optional.ofNullable(user).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "find-user-and-info-by-userid")
    @ApiOperation(value = "find-user-and-info-by-userid" , notes = "find-user-and-info-by-userid")
    public ResponseEntity<Map> findUserAndInfoByUserId(@ApiParam(name = "id", value = "id") @RequestParam(name = "id", required = false, defaultValue = "0") Long id) {
        Map map = this.userService.findUserAndInfoByUserId(id);
        log.info(JSONObject.toJSONString(map));
        return Optional.ofNullable(map).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
