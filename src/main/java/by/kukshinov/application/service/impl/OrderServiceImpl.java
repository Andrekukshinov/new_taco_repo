package by.kukshinov.application.service.impl;

import by.kukshinov.application.entity.Order;
import by.kukshinov.application.exceptions.ServiceException;
import by.kukshinov.application.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void saveOrder(Order order) throws ServiceException {
        //ignored
    }
}
