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
@Table(name = "toys")
public class ToyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toyId;
    private String productCode;
    private Double price;
    private String description;
    private String imageURL;
}
