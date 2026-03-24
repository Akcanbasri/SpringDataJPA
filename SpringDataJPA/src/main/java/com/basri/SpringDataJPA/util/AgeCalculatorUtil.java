package com.basri.SpringDataJPA.util;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorUtil {
    
    // Doğum tarihinden bugünkü yaşı hesaplayan yardımcı metot
    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            return 0;
        }
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
