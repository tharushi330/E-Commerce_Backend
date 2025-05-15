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
@Table(name = "flowers")
public class FlowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flowerId;
    private String name;
    private String productCode;
    private Double price;
    private String description;

}
