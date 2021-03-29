package by.kukshinov.application.controller;

import by.kukshinov.application.exceptions.ServiceException;
import by.kukshinov.application.entity.Taco;
import by.kukshinov.application.service.IngredientsService;
import by.kukshinov.application.service.TacoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.Errors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class TacoControllerTest {
    private static final String EXPECTED_PATH = "redirect:/orders/current";
    private static final String ERROR_PAGE = "redirect:/error";
    private static final String DESIGN_PAGE = "design";


    @Mock
    private TacoService tacoService;
    @Mock
    private IngredientsService ingredientsService;
    @Mock
    private Errors errors;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(errors.hasErrors()).thenReturn(false);
    }

    @Test
    public void testSaveTacoShouldReturnRedirectToOrderCurrent() throws ServiceException {
        TacoController controller = new TacoController(ingredientsService, tacoService);
        doNothing().when(tacoService).saveTaco(any());

        String actualPath = controller.saveTaco(new Taco(), errors);

        Assert.assertEquals(EXPECTED_PATH, actualPath);
    }

    @Test
    public void testSaveTacoShouldReturnRedirectToDesignPageWhenInvalidTaco() throws ServiceException {
        TacoController controller = new TacoController(ingredientsService, tacoService);
        doNothing().when(tacoService).saveTaco(any());
        when(errors.hasErrors()).thenReturn(true);

        String actualPath = controller.saveTaco(new Taco(), errors);

        Assert.assertEquals(DESIGN_PAGE, actualPath);
    }

    @Test
    public void testSaveTacoShouldReturnRedirectToErrorPageWhenExceptionIsThrown() throws ServiceException {
        TacoController controller = new TacoController(ingredientsService, tacoService);
        doThrow(ServiceException.class).when(tacoService).saveTaco(any());

        String actualPath = controller.saveTaco(new Taco(), errors);

        Assert.assertEquals(ERROR_PAGE, actualPath);
    }

//    @Test
//    public void testShowDesignFormShouldReturnDesignPageAndFillTheModel() {
//
//    }
}
//@RunWith(SpringRunner.class)
//@WebMvcTest(TacoController.class)
//@ComponentScan("by.kukshinov.application.service")


//@Autowired
//private MockMvc mockMvc;
//     module testing
//     @Test
//     public void test () throws Exception {
//          mockMvc.perform(get("/design"))
//                  .andExpect(status().isOk())
//                  .andExpect(view().name("design"))
//          ;
//     }
