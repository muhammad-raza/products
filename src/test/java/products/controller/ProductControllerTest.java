package products.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ProductController.class})
@WebAppConfiguration
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testProductController() throws Exception {
        mockMvc.perform(get("/product").cookie(new Cookie("customerID", "customer1")))
                .andExpect(status().isOk())
                .andExpect(view().name("catalogues"))
                .andExpect(model().attribute("customerID", is("customer1")))
                .andExpect(model().attributeExists("locationBasedCatalogue"));
    }

    @Test
    public void testProductControllers() throws Exception {
        mockMvc.perform(get("/product").cookie(new Cookie("customerID", "unknown")))
                .andExpect(status().isOk())
                .andExpect(view().name("catalogues"))
                .andExpect(model().attributeDoesNotExist("customerID"))
                .andExpect(model().attributeDoesNotExist("locationBasedCatalogue"));
    }
}