package com.example.springweb.entity;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@ToString
@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code_sell;
    @Column
    private String name;
    @Column
    private Long price;
    @Column
    private int quantity;
    @Column
    private String image;
    @Column
    private  int timeInsurance;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CategoryEntity categoryEntity;
    @ManyToMany(mappedBy = "productEntities")
    @EqualsAndHashCode.Exclude
    private Collection<BillEntity> billEntities;
    @ManyToMany(mappedBy = "productE")
    @EqualsAndHashCode.Exclude
    private Set<InsuranceEntity> insuranceEntities=new HashSet<>();
}
