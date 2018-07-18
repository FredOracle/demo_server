package com.example.common.entity;

import com.example.common.entity.base.BaseNamedEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "`order`")
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseNamedEntity {

    @Column
    private Integer status;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = {@JoinColumn(name = "`order`", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "`product`", referencedColumnName = "id")}
    )
    private List<Product> products;

    @Builder
    public Order(String id, Date createtime, Date updatetime, String description, Integer status, List<Product> products){
        super(id, "", createtime, updatetime, description);
        this.status = status;
        this.products = products;
    }

}
