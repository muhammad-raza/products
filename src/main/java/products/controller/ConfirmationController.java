package products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfirmationController {

    @RequestMapping(value="/confirmation")
    public String getConfirmation() {
        return "confirm";
    }
}

