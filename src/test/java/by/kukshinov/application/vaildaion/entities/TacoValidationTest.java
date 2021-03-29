package by.kukshinov.application.vaildaion.entities;

import by.kukshinov.application.entity.Taco;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class TacoValidationTest {
    public static final String NAME = "name";
    public static final String CHEESE = "FLO";
    public static final String SAUCE = "SAUCE";
    public static final String EMPTY = "";
    public static final int INVALID_FIELDS_AMOUNT = 2;

    private static Validator validator;

    @BeforeClass
    public static void initMocks() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

     @Test
     public void testValidationShouldValidateTacoWhenDataIsValid () {
         Taco taco = new Taco(NAME, List.of(CHEESE, SAUCE));

         Set<ConstraintViolation<Taco>> errors = validator.validate(taco);

         Assert.assertTrue(errors.isEmpty());
     }

     @Test
     public void testValidationShouldNotValidateTacoWhenDataIsInvalid () {
         Taco taco = new Taco(EMPTY, Collections.emptyList());

         Set<ConstraintViolation<Taco>> errors = validator.validate(taco);

         Assert.assertEquals(errors.size(), INVALID_FIELDS_AMOUNT);
     }
}
