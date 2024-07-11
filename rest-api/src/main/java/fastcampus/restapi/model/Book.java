package fastcampus.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;
}
