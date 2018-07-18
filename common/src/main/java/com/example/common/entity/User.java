package com.example.common.entity;

import com.example.common.entity.base.BaseNamedEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "`user`")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseNamedEntity {

    @Column
    private String password;

    @Column
    private Integer age;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Order> orders;

    @Builder
    public User(String id, String name, Date createtime, Date updatetime, String description, String password, Integer age, List<Order> orders){
        super(id, name, createtime, updatetime, description);
        this.password = password;
        this.age = age;
        this.orders = orders;
    }

}
