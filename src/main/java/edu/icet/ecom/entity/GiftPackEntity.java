package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "giftPacks")
public class GiftPackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long giftPackId;
    private String name;
    private String productCode;
    private String description;
    private String imageURL;
    private Double price;

}
