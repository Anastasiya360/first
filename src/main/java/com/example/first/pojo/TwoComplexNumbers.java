package com.example.first.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwoComplexNumbers {

    private ComplexNumber numberOne;
    private ComplexNumber numberTwo;
}
