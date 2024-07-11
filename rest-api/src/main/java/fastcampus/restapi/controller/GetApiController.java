package fastcampus.restapi.controller;

import fastcampus.restapi.model.Book;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GetApiController {
    @GetMapping("/hello-spring-boot")
    public String hello() {
        return "<html> <body> <h1> Hello Spring Boot! </h1> </body> </html>";
    }

    @GetMapping("/path/{message}/{age}/{gender}")
    public String getPathVariable(
            @PathVariable String message,
            @PathVariable int age,
            @PathVariable boolean gender
    ) {
        System.out.println("PathVariable : " + message);
        System.out.println("PathVariable : " + age);
        System.out.println("PathVariable : " + gender);
        return message.toUpperCase();
    }

    @GetMapping("/book")
    public void getQueryParam(
            @RequestParam String category,
            @RequestParam(name = "issued-year") String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued-day") String issuedDay
    ) {
      System.out.println(category);
      System.out.println(issuedYear);
      System.out.println(issuedMonth);
      System.out.println(issuedDay);
    }

    @GetMapping("/bookData")
    public void getQueryParamDto(
            Book book
    ) {
        System.out.println(book);
    }
}
