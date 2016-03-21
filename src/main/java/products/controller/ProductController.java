package products.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import products.client.ProductsClient;

@Controller
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductsClient client = new ProductsClient();

    @RequestMapping(value="/product")
    public String getProducts(Model model, @CookieValue(value = "customerID", required = false) String customerIdCookie,
                              @RequestParam(value= "customerID", required = false) String customerIdParam) {

        String customerID = "customer1";
        if (has(customerIdParam)){
            customerID = customerIdParam;
        } else if (has(customerIdCookie)){
            customerID = customerIdCookie;
        }

        try {
            model.addAttribute("locationBasedCatalogue", client.getCataloguesFor(customerID));
            model.addAttribute("customerID", customerID);
        } catch (Exception e) {
            LOGGER.error("Unable to execute request");
        }

        return "catalogues";
    }

    private boolean has(String value) {
        return !(value == null || value.isEmpty());
    }
}
