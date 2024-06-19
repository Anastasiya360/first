package com.example.first.controller;

import com.example.first.pojo.ComplexNumber;
import com.example.first.pojo.TwoComplexNumbers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class MathController {
    private List<ComplexNumber> complexNumbers = new ArrayList<>();

    @GetMapping(path = "/sum")
    public ResponseEntity<?> sum(@RequestParam Integer number1, @RequestParam Integer number2) {
        return ResponseEntity.ok(Integer.toString(number1 + number2));
    }

    @GetMapping(path = "/difference")
    public ResponseEntity<?> difference(@RequestParam Integer number1, @RequestParam Integer number2) {
        return ResponseEntity.ok(Integer.toString(number1 - number2));
    }

    @GetMapping(path = "/division")
    public ResponseEntity<String> division(@RequestParam Integer number1, @RequestParam Integer number2) {
        return ResponseEntity.ok(Integer.toString(number1 / number2));
    }

    @GetMapping(path = "/mul")
    public ResponseEntity<String> mul(@RequestParam Integer number1, @RequestParam Integer number2) {
        return ResponseEntity.ok(Integer.toString(number1 * number2));
    }

    @PostMapping(path = "/complex/add")
    public ResponseEntity<?> complexAdd(@RequestBody ComplexNumber number) {
        if (complexNumbers == null) {
            return ResponseEntity.badRequest().body("\"К сожалению список чисел не инициализирован\"");
        }
        if (number == null) {
            return ResponseEntity.badRequest().body("number не передан");
        }
        if (number.getReal() == null) {
            return ResponseEntity.badRequest().body("real не передан");
        }
        if (number.getImaginary() == null) {
            return ResponseEntity.badRequest().body("imaginary не передан");
        }
        complexNumbers.add(number);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/complex/get")
    public ResponseEntity<?> complexGet() {
        if (complexNumbers == null) {
            return ResponseEntity.badRequest().body("List не заполнен");
        }
        return ResponseEntity.ok(complexNumbers);
    }

    @DeleteMapping(path = "/complex/del")
    public ResponseEntity<?> complexDel(@RequestBody ComplexNumber number) {
        try {
            complexNumbers.remove(number);
        } catch (Exception e) {
            log.error("List не заполнен");
        }
        return ResponseEntity.ok(complexNumbers.remove(number));
    }
    @PutMapping(path = "/complex/put/index")
    public ResponseEntity<?> complexPut (@RequestBody ComplexNumber number, @RequestParam int index) {
        return ResponseEntity.ok(complexNumbers.set(index, number));
    }

    /**
     *
     * "NumberOne" объект который необходимо заменить
     * "NumberTwo" на какой объект необходимо заменить
     * @return
     */
    @PutMapping(path = "/complex/put")
    public ResponseEntity<?> complexPut (@RequestBody TwoComplexNumbers numbers) {
        return ResponseEntity.ok(complexNumbers.set(complexNumbers.indexOf(numbers.getNumberOne()), numbers.getNumberTwo()));
    }
}
