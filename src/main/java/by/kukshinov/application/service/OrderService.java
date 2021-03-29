package by.kukshinov.application.service;

import by.kukshinov.application.entity.Order;
import by.kukshinov.application.exceptions.ServiceException;

public interface OrderService {
    void saveOrder(Order order) throws ServiceException;
}
