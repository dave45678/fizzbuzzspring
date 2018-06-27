package com.example.fizzbuzz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    ArrayList<String> output = new ArrayList<String>();

    @RequestMapping("/form")
    public String loadForm(Model model) {
        model.addAttribute("newfizzbuzz", new FizzBuzz());
        return "fizzbuzzform";
    }

    @RequestMapping("/process")
    public String processForm(@ModelAttribute("newfizzbuzz") FizzBuzz fizzbuzz,
                              BindingResult result, Model model) {
        model.addAttribute("output", output);
        if (result.hasErrors()) {
            return "fizzbuzzform";
        }
        else {
            for (int i=fizzbuzz.getStartNumber(); i<=fizzbuzz.getEndNumber(); i++) {
                if (i%3==0 && i%5==0) {
                    output.add("Fizzbuzz");
                }
                else if (i%3==0) {
                    output.add("Fizz");
                }
                else if (i%5==0) {
                    output.add("Buzz");
                }
                else {
                    output.add(String.valueOf(i));
                }
            }
            return "myresult";
        }
    }

}
