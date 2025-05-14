package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Flowers {
    private Long flowerId;
    private String name;
    private String productCode;
    private Double price;
    private String description;

}
