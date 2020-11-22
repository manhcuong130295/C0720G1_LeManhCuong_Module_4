package service.impl;

import org.springframework.stereotype.Service;
import service.ConversionService;

@Service
public class ConvertUsdToVndService implements ConversionService {
    @Override
    public int convert(int usd) {
        return usd*23000;
    }
}
