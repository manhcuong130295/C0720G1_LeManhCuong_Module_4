package service.impl;

import org.springframework.stereotype.Service;
import service.ConversionService;
@Service
public class ConvertVndToUsd implements ConversionService {
    @Override
    public int convert(int vnd) {
        return vnd/23000;
    }
}
