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
@Table(name = "cakes")
public class CakeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cakeId;
    private String productCode;
    private String name;
    private String weight;
    private String description;
    private String imageURL;
    private Double price;

}
