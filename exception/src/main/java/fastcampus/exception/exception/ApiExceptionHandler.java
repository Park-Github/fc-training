package fastcampus.exception.exception;
import fastcampus.exception.controller.RestApiBController;
import fastcampus.exception.controller.RestApiController;
import fastcampus.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@Order(1)
//@RestControllerAdvice(basePackages = "fastcampus.exception.controller") 특정 패키지 예외처리
@RestControllerAdvice(basePackageClasses = {RestApiBController.class, RestApiController.class}) // 특정 클래스 예외처리
public class ApiExceptionHandler {

    // 모든 예외를 핸들링
    @ExceptionHandler(Exception.class)
    public ResponseEntity exception(Exception e) {
      log.error("Exception", e);
      // 에러 메시지를 로깅 후 HTTP 응답
      return ResponseEntity.status(500).build();
    }

    // 특정 예외를 핸들링
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity outOfBoundsException(Exception e) {
        log.error("IndexOutOfBounds", e);
        return ResponseEntity.status(500).build();
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity numberFormatException(Exception e) {
        log.error("NumberFormatException", e);
        return ResponseEntity.status(500).build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Api> noSuchElement(Exception e) {
        log.error("NoSuchElementException", e);

        Api api = Api.builder()
                .resultMessage(HttpStatus.NOT_FOUND.name())
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(api);
    }

}
