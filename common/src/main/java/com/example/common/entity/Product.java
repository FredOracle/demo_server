package com.example.common.entity;

import com.example.common.entity.base.BaseNamedEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "`product`")
public class Product extends BaseNamedEntity {

    private Double price;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = {@JoinColumn(name = "`product`", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "`order`", referencedColumnName = "id")}
    )
    private List<Order> orders;

    @Builder
    public Product(String id, String name, Date createtime, Date updatetime, String description, Double price, List<Order> orders){
        super(id, name, createtime, updatetime, description);
        this.price = price;
        this.orders = orders;
    }

}
