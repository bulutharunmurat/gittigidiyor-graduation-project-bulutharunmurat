package dev.patika.creditscorecalculator.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @ApiModelProperty(example = "12345678902")
    @NotNull(message = "SSID is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private long ssid;

    @ApiModelProperty(example = "Harun Murat Bulut")
    @NotBlank(message = "Name is mandatory!!!")
    private String customerName;

    @ApiModelProperty(example = "5000.0")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Float customerSalary;

    @ApiModelProperty(example = "05310123456")
    @NotBlank
    private String customerPhoneNumber;

}
