package com.example.first.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComplexNumber {

    private Integer real;
    private Integer imaginary;

    public String toString() {
        return real + " + " + imaginary + "i";
    }
}
