package org.devschool.web.pizza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ds_pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "pizza_seq", sequenceName = "ds_pizza_seq")
public class PizzaEntity {

    @Id
    @GeneratedValue(generator = "pizza_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;
}
