package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cakes {
    private Long cakeId;
    private String productCode;
    private String name;
    private String weight;
    private String description;
    private String imageURL;
    private Double price;

}
