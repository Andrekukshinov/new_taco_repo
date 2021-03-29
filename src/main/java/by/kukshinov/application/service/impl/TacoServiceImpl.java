package by.kukshinov.application.service.impl;


import by.kukshinov.application.entity.Taco;
import by.kukshinov.application.service.TacoService;
import by.kukshinov.application.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class TacoServiceImpl implements TacoService {
    @Override
    public void saveTaco(Taco taco) throws ServiceException {
        if (taco.getName() == null || taco.getName().isEmpty()) {
            throw new ServiceException("null");
        }
        System.out.println("SUCCESSFULLY SAVED TACO: " + taco);
    }
}
