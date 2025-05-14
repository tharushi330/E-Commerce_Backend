package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GiftPack {
    private Long giftPackId;
    private String productCode;
    private String description;
    private String imageURL;
    private Double price;

}
