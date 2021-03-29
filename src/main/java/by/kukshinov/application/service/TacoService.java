package by.kukshinov.application.service;

import by.kukshinov.application.entity.Taco;
import by.kukshinov.application.exceptions.ServiceException;

public interface TacoService {
    void saveTaco(Taco taco) throws ServiceException;
}
