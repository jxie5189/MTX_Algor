package com.example.mtx_algor2.Controller;

import com.example.mtx_algor2.Model.MTX_Algor;
import com.example.mtx_algor2.Model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MTXController {

    @GetMapping("/")
    public String sendForm(Model model){
        model.addAttribute("patient", new Patient());
        return "index";
    }


    @PostMapping("/run")
    public String processForm(@Valid @ModelAttribute
                                   Patient patient, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "index";
        }

        System.out.println(patient.toString());
        MTX_Algor mtx_algor = new MTX_Algor(patient);
        String result = mtx_algor.Run();
        model.addAttribute("result", result);
        return "index";
    }
}
