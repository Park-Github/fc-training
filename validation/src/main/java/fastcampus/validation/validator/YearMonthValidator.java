package fastcampus.validation.validator;

import fastcampus.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;
    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // "2023-01-01T13:00:00" yyyy-MM-ddTHH:mm:ss

        var revalue = value + "01";
        var rePattern = pattern + "dd";

        try {
            LocalDate date = LocalDate.parse(revalue, DateTimeFormatter.ofPattern(rePattern));
            System.out.println(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

