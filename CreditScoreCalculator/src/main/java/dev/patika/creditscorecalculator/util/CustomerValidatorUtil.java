package dev.patika.creditscorecalculator.util;

import dev.patika.creditscorecalculator.exceptions.BadRequestException;

public class CustomerValidatorUtil {

    /**
     *
     * @param salary
     */
    public static void validateSalary(double salary) {
        if(salary < 0){
            throw new BadRequestException(String.format("Salary cannot be a negative number!"));
        }
    }
}
