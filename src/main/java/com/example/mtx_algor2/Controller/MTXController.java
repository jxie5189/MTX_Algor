package com.example.mtx_algor2.Controller;

import com.example.mtx_algor2.Model.MTX_Algor;
import com.example.mtx_algor2.Model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MTXController {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

    @GetMapping("/")
    public String sendForm(Model model){
        model.addAttribute("patient", new Patient());
        return "index";
    }


    @PostMapping("/run")
    public String processForm(@ModelAttribute
                                   Patient patient,
                                    Model model,
                              BindingResult bindingResult
    ){

        if(bindingResult.hasErrors()){
            return "index";
        }

        String mtxStartDateTime = LocalDateTime.of(patient.getInfusionStartDate(),
                patient.getInfusionStartTime()).format(formatter).toString();

        String mtxCheckDateTime = LocalDateTime.of(patient.getMtx_checkDate(),
                patient.getMtx_checkTime()).format(formatter).toString();

        String mtxLevel = patient.getMtxlvl();


        System.out.println(patient.toString());
        MTX_Algor mtx_algor = new MTX_Algor(patient);
        String result = mtx_algor.Run();
        model.addAttribute("mtxStartDateTime", mtxStartDateTime);
        model.addAttribute("mtxCheckDateTime", mtxCheckDateTime);
        model.addAttribute("mtxLevel", mtxLevel);
        model.addAttribute("result", result);
        return "result";
    }
}
