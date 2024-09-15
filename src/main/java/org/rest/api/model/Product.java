package org.rest.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long productId;
  private  String  productName;
  private  double  price;
  private  String description;
  private  String status;

}
