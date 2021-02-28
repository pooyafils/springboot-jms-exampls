package com.example.jmsmessaging.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyMessage implements Serializable {
    static final long serialVersionUID = -6703826490277916847L;
private int id;
private String myMessage;

}
