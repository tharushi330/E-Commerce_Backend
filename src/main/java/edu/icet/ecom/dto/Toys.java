package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Toys {
    private Long toyId;
    private String productCode;
    private Double price;
    private String description;
    private String imageURL;
}
