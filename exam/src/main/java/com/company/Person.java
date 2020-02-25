package com.company;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@XmlRootElement(name = "user")

public class Person {
    private String name;
    private int year;
    private int age;
}
