package com.example.common.entity.base;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public abstract class BaseNamedEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private Date createtime;

    @Column
    private Date updatetime;

    @Column
    private String description;

    public BaseNamedEntity(String id, String name, Date createtime, Date updatetime, String description){
        super(id);
        this.name = name;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.description = description;
    }


}
