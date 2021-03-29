package by.kukshinov.application.vaildaion.entities;

import by.kukshinov.application.entity.Order;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class OrderValidationTest {
    private static final String NAME = "order";
    private static final String STREET = "tim";
    private static final String CITY = "Min";
    private static final String STATE = "Minsk distr";
    private static final String ZIP = "zxc";
    private static final String CC_NUMBER_VALID = "5105105105105100";
    private static final String EXPIRATION = "12/22";
    private static final String EXPIRATION_INVALID = "00/22";
    private static final String CVV = "753";
    private static final String EMPTY = "";
    private static final int INVALID_FIELDS_AMOUNT = 4;

    private static Validator validator;

    @BeforeClass
    public static void initValidators() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testTacoValidationShouldValidateOrderWhenObjectIsValid() {
        //given
        Order order = new Order(NAME, STREET, CITY, STATE, ZIP, CC_NUMBER_VALID, EXPIRATION, CVV);
        //when
        Set<ConstraintViolation<Order>> actual = validator.validate(order);
        //then
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testTacoValidationShouldNotValidateOrderWhenEmptyFields() {
        //given
        Order order = new Order(EMPTY, EMPTY, EMPTY, STATE, ZIP, CC_NUMBER_VALID, EXPIRATION_INVALID, CVV);
        //when
        Set<ConstraintViolation<by.kukshinov.application.entity.Order>> actual = validator.validate(order);
        //then
        Assert.assertEquals(INVALID_FIELDS_AMOUNT, actual.size());
    }

}
