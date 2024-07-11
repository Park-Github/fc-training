package fastcampus.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class DeleteApiController {
    @DeleteMapping(path = {"/{userName}/delete", "/{userName}/del"})
    public void deleteUser(
            @PathVariable String userName
    ) {
        log.info(userName);
    }
}
