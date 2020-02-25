package com.company;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@XmlRootElement(name = "person")

public class Person {
    private int id;
    private String name;
    private int year;
    private int age;
}
