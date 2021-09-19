package dev.patika.creditscorecalculator.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditScoreAppErrorMessage {
    private int status;
    private String message;
    private long timestamp;
}
