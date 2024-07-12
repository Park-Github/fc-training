package fastcampus.restapi.controller;

import fastcampus.restapi.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequestMapping("/api")
public class ResponseController {

    @GetMapping("/controller/user-entity")
    @ResponseBody
    public ResponseEntity<User> UserEntity() {
        User user = new User("박승호", "01091161499",
                "dreamhigh924@gmail.com", true);
        log.info(String.valueOf(user));
        var response = ResponseEntity
                .status(HttpStatus.OK)
                .header("x-custom-header", "testValue")
                .body(user);
        return response;
    }

}
