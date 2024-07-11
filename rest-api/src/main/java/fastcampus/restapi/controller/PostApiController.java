package fastcampus.restapi.controller;

import fastcampus.restapi.model.Book;
import fastcampus.restapi.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post/book")
    public Book postBook(
            @RequestBody Book book
    ) {
        System.out.println(book);

        // 클라이언트에 객체를 Response 하면 Json 으로 변환됨
        return book;
    }

    @PostMapping("/post/user")
    public User postUser(
            @RequestBody User user
    ) {
        System.out.println(user);
        return user;
    }
}
