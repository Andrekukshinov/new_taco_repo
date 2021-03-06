package by.kukshinov.application.controller;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {
    public static final String EXPECTED_ADDRESS = "home";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testShouldReturnHomePageNameIsolated () {
        HomeController controller = new HomeController();

        String actual = controller.home();

        Assert.assertEquals(actual, EXPECTED_ADDRESS);
    }
//module testing
    @Test
    public void testShouldReturnHomePageNameAfterRequestIsPerformed() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(
                        containsString("Welcome to...")
                ));
    }

}
