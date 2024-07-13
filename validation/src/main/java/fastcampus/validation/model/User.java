package fastcampus.validation.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import fastcampus.validation.annotation.PhoneNumber;
import fastcampus.validation.annotation.YearMonth;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
//    @NotNull // != null
//    @NotEmpty // != null && != ""
//    @NotBlank // != null && != "" && != " "
    @NotBlank
    private String name;

    @NotBlank
    private String nickName;

    @Size(min = 1, max = 10)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer age;

    @Email
    private String email;


//    @Pattern(regexp = "\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호가 양식에 맞지 않음.")
    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent //현재 또는 미래의 날짜만 지정
    private LocalDateTime registerDate;

    @YearMonth(pattern = "yyyy-MM")
    private String BirthDayYearMonth;

    @AssertTrue(message = "name or nickname 은 존재해야 합니다.") // return 값이 false 일 때 에러 메시지 출력
    public boolean isNameCheck() {
        if (nickName.isBlank() && name.isBlank())
            return false;

        return true;
    }

}
