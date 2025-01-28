package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("leftValue") String leftValueStr,
                          @RequestParam("rightValue") String rightValueStr,
                          Model model) {

        // エラーチェック
        String errorMessage = "";
        if (leftValueStr.isEmpty() || rightValueStr.isEmpty()) {
            errorMessage = "未入力の値があります。";
        } else {
            try {
                double leftValue = Double.parseDouble(leftValueStr);
                double rightValue = Double.parseDouble(rightValueStr);
                double result = leftValue + rightValue; // 演算子は必要に応じて変更
                model.addAttribute("result", result);
            } catch (NumberFormatException ex) {
                errorMessage = "数値以外の値が入力されています。";
            }
        }

        model.addAttribute("errorMessage", errorMessage);
        return "index";
    }
}