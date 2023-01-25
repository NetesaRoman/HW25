package com.example.hw25.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/*
 *
 * @author Roman Netesa
 *
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "my_store")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate creationDate;
    private Double price;

    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
