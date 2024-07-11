package fastcampus.restapi.controller;

import fastcampus.restapi.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {

    public User putUser(
            @RequestBody User user
    ) {
        // log 는 버퍼에 담겨 프로그램 실행 후 출력되기 때문에 실행 속도를 최적화할 수 있음
        log.info("Request : {}", user);
        return user;
    }
}
