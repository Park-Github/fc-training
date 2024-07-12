package fastcampus.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fastcampus.restapi.model.User;
import fastcampus.restapi.model.UserTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RestApiApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    // ObjecMapper 는 get method 를 기준으로 Json write
    // set method 를 기준으로 Json read

    @Test
    void testObjectMapper1() throws JsonProcessingException {
        User user = new User();
        user.setEmail("dreamhigh924@gmail.com");
        user.setUserName("박승호");
        user.setPhoneNumber("01091161499");
        user.setIsKorean(true);

        var json = objectMapper.writeValueAsString(user);
        var dto = objectMapper.readValue(json, User.class);

        System.out.println(json);
        System.out.println(dto);
    }

    @Test
    void testObjectMapper2() throws JsonProcessingException {
        UserTest user = new UserTest("박승호", "dreamhigh924@gmail.com", "01091161499", true);
        System.out.println(user);
        var json = objectMapper.writeValueAsString(user);
        var dto = objectMapper.readValue(json, User.class);

        System.out.println(json);
        System.out.println(dto);
    }

    @Test
    void testObjectMapper3() throws JsonProcessingException {
        UserTest user = new UserTest("박승호", "dreamhigh924@gmail.com", "01091161499", true);
        System.out.println(user);
        var json = "{\"user_name\":\"박승호\",\"phone_number\":\"01091161499\",\"is_man\":true,\"user_email\":\"dreamhigh924@gmail.com\"}";
        var dto = objectMapper.readValue(json, UserTest.class);

        System.out.println(json);
        System.out.println(dto);
    }

}
