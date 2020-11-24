package com.c0720g1.manhcuong.service.Impl;

import com.c0720g1.manhcuong.service.CaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorServiceImpl implements CaculatorService {
    @Override
    public int caculating(int num1, int num2, String operator) {
        int result = 0;
        if (num2 != 0) {
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
        } else {
            throw new ArithmeticException("Cannot division by zero");
        }
        return result;
    }
}
