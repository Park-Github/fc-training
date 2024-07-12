package fastcampus.exception.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping("/hello")
    public void hello() {
        // ExceptionHandler 가 아닌 Controller 단에서 예외를 따로 처리할 수 있음
        throw new NumberFormatException("number format exception");
    }
}
