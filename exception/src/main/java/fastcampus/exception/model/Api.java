package fastcampus.exception.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
// 예외 상황을 고려하여 모든 케이스에서 정해진 형식의 데이터를 보내도록 API 를 설계
public class Api<T> {
    // 데이터 처리 관련 메시지
    private String resultCode;
    private String resultMessage;

    // 데이터를 받을 변수
    // Generic 타입을 사용하여 데이터를 통신할 때 어떤 타입이든 받을 수 있도록 함
    private T data;
}
