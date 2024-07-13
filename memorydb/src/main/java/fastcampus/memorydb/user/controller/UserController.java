package fastcampus.memorydb.user.controller;

import fastcampus.memorydb.user.model.UserEntity;
import fastcampus.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity user) {
        return userService.save(user);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }
}
