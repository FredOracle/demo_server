package com.example.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    private String time;

    private String type;

    private String content;

    @Override
    public String toString(){
        String separate = ":";
        return time + separate + type + separate + content;
    }

}
