package by.kukshinov.application.controller;


import by.kukshinov.application.entity.Order;
import by.kukshinov.application.exceptions.ServiceException;
import by.kukshinov.application.service.OrderService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/orders")
public class OrderController {
    private static final Logger LOGGER = LogManager.getLogger(OrderController.class);
    private static final String ORDER = "order";
    private static final String ORDER_FORM_PAGE = "orderForm";
    private static final String ERROR_PAGE = "redirect:/error";
    private static final String HOME = "redirect:/";

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/current")
    public String orderPage(Model model) {
        model.addAttribute(ORDER, new Order());
        return ORDER_FORM_PAGE;
    }

    @PostMapping
    public String saveOrder(@Valid Order order, Errors errors) {
        if(errors.hasErrors()){
            return ORDER_FORM_PAGE;
        }
        try {
            orderService.saveOrder(order);
        } catch (ServiceException e) {
            LOGGER.error(e.getMessage(), e);
            return ERROR_PAGE;
        }
        return HOME;
    }

}
