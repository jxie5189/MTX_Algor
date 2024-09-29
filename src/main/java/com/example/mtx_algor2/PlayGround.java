package com.example.mtx_algor2;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.example.mtx_algor2.Model.MTX_Algor;
import com.example.mtx_algor2.Model.Patient;

public class PlayGround {

    public static void main(String[] args){


        Patient pt = new Patient();

        Scanner input = new Scanner(System.in);

        pt.setInfusionStartTime(LocalTime.of(10, 00));
        pt.setInfusionStartDate(LocalDate.of(2024, 8, 1));

        System.out.println("input mtx level");
        String mtx_lvl = input.nextLine();

        pt.setMtxlvl(mtx_lvl);
        pt.setMtx_checkDate(LocalDate.of(2024, 8,1));
        pt.setMtx_checkTime(LocalTime.of(16, 00));


        MTX_Algor mtx_algor = new MTX_Algor(pt);
        mtx_algor.Run();

        System.out.println(pt.toString());








    }
}
