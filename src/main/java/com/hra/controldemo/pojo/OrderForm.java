package com.hra.controldemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderForm {
    private String pId;
    private String sId;
    private Map<String,String> command;
}
