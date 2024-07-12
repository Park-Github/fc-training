package fastcampus.validation.Controller;

import fastcampus.validation.model.Api;
import fastcampus.validation.model.User;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public Api<User> register(
            @Valid
            @RequestBody Api<User> userApi
//            BindingResult bindingResult // BindingResult : Valid 결과를 저장
    ) {
        log.info(String.valueOf(userApi));

        var response = userApi.getData();
        Api<User> api = Api.<User>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(response)
                .build();
        return api;
    }
}
