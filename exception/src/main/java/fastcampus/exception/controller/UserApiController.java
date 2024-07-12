package fastcampus.exception.controller;

import fastcampus.exception.model.Api;
import fastcampus.exception.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.rmi.AccessException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static List<User> userList = List.of(
            User.builder()
                .id(1)
                .age(10)
                .name("박승호")
                .build(),
            User.builder()
                    .id(2)
                    .age(12)
                    .name("홍길동")
                    .build()
    );

    @GetMapping("/id/{userId}")
    public Api<User> getUser(
            @PathVariable int userId
    ) throws Exception {
        if (true)
            throw new AccessException("AccessException");

        var user = userList.stream().
                filter(user1 -> user1.getId() == userId)
                .findFirst()
                .get();

        Api<User> response = Api.
                <User>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage((HttpStatus.OK.name()))
                .data(user)
                .build();

        return response;
    }
}
