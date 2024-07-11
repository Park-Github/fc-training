package fastcampus.restapi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    private String userName;
    private String phoneNumber;
    private String email;
    // Json 데이터를 받을 때는 Primitive 타입(boolean)이 아닌 Reference 타입의 데이터(Boolean)로 받는다.
    private Boolean isKorean;
}
