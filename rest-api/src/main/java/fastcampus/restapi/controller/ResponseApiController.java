package fastcampus.restapi.controller;

import fastcampus.restapi.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ResponseApiController {

    @GetMapping("/user")
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User User() {
        User user = new User("박승호", "01091161499",
                "dreamhigh924@gmail.com", true);
        log.info(String.valueOf(user));
        return user;
    }

    @GetMapping("/user-string")
    public String UserString() {
        User user = new User("박승호", "01091161499",
                "dreamhigh924@gmail.com", true);
        log.info(String.valueOf(user));
        return user.toString();
    }

    // HTTP header 에 status 코드나 값을 보내야 할 때 : ResponseEntity
    @GetMapping("/user-entity")
    public ResponseEntity<User> UserEntity() {
        User user = new User("박승호", "01091161499",
                "dreamhigh924@gmail.com", true);
        log.info(String.valueOf(user));

        var response = ResponseEntity
                .status(HttpStatus.CREATED)
                .header("x-custom-header", "testValue")
                .body(user);
        return response;
    }

}
