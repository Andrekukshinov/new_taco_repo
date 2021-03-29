package by.kukshinov.application.controller;


import by.kukshinov.application.entity.Order;
import by.kukshinov.application.exceptions.ServiceException;
import by.kukshinov.application.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderControllerTest {
    private static final String EXPECTED_PATH = "redirect:/";
    private static final String ERROR_PAGE = "redirect:/error";
    private static final String ORDER_FORM_PAGE = "orderForm";


    @Mock
    private OrderService orderService;
    @Mock
    private Errors errors;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveTacoShouldReturnRedirectToOrderCurrent() throws ServiceException {
        OrderController controller = new OrderController(orderService);
        doNothing().when(orderService).saveOrder(any());
        when(errors.hasErrors()).thenReturn(false);

        String actualPath = controller.saveOrder(new Order(), errors);

        Assert.assertEquals(EXPECTED_PATH, actualPath);
    }

    @Test
    public void testSaveTacoShouldReturnRedirectToErrorPageWhenExceptionIsThrown() throws ServiceException {
        OrderController controller = new OrderController(orderService);
        doThrow(ServiceException.class).when(orderService).saveOrder(any());
        when(errors.hasErrors()).thenReturn(false);

        String actualPath = controller.saveOrder(new Order(), errors);

        Assert.assertEquals(ERROR_PAGE, actualPath);
    }

    @Test
    public void testSaveTacoShouldReturnRedirectToErrorPageWhenInvalidOrder() throws ServiceException {
        OrderController controller = new OrderController(orderService);
        doNothing().when(orderService).saveOrder(any());
        when(errors.hasErrors()).thenReturn(true);

        String actualPath = controller.saveOrder(new Order(), errors);

        Assert.assertEquals(ORDER_FORM_PAGE, actualPath);
    }
}
