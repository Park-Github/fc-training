package fastcampus.validation.exception;

import fastcampus.validation.model.Api;
import fastcampus.validation.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

// Exception Handler 객체에서 Controller 에서 발생한 Valid Exception 을 처리
// 비즈니스 로직에 예외처리 코드를 없앨 수 있음
@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Api<? extends Object>> validationException(
            final MethodArgumentNotValidException exception // Validation 결과가 저장됨
    ) {
        log.error(exception.getMessage());
            var ErrorList = new ArrayList<String>();
            var format = "%s : { %s } %s";
            exception.getAllErrors()
                    .forEach(objectError -> {
                        FieldError fieldError = (FieldError) objectError;
                        ErrorList.add(String.format(format, fieldError.getField(),
                                fieldError.getRejectedValue(),fieldError.getDefaultMessage()));
                    });

            var error = Api.Error
                    .builder()
                    .errorMessage(ErrorList)
                    .build();

            var errorResponse = Api.<User>builder()
                    .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                    .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                    .error(error)
                    .build();

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
    }
}
