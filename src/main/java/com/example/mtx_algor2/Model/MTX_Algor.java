package com.example.mtx_algor2.Model;

import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MTX_Algor {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
    Patient pt;
    LocalDateTime startDateTime;
    float mtxlvl;
    LocalDateTime mtx_checkTime;

    public MTX_Algor(Patient pt) {
        this.pt = pt;
        this.mtxlvl = Float.parseFloat(pt.getMtxlvl());
        this.startDateTime = LocalDateTime.of(pt.getInfusionStartDate(), pt.getInfusionStartTime());
        this.mtx_checkTime = LocalDateTime.of(pt.getMtx_checkDate(), pt.getMtx_checkTime());
    }

    public long timeSpent(LocalDateTime start, LocalDateTime end) {
        Duration timeSpent = Duration.between(start, end);
        return timeSpent.toHours();
    }

    public String Run() {

        long timeSpent = timeSpent(startDateTime, mtx_checkTime);

        switch ((int) timeSpent) {
            case 2:
                if (mtxlvl < 100) {
                    System.out.println("Continue current Rate and re-check at hour 6, " +
                            startDateTime.plusHours(6).format(formatter));
                    return "Continue current Rate and re-check at hour 6, " +
                            startDateTime.plusHours(6).format(formatter);
                } else {
                    System.out.println("Stop infusion for 1 hr,\n" +
                            "Restart at 50% reduction, then check level at hour 8, " +
                            startDateTime.plusHours(8).format(formatter));

                    return "Stop infusion for 1 hr,\nRestart at 50% reduction, then check level at hour 8, " +
                            startDateTime.plusHours(8).format(formatter);
                }
            case 6, 8:
                if (mtxlvl < 75) {
                    System.out.println("Continue current rate");
                    System.out.println("Resume checked MTX level per standard of care");
                    return "Continue current rate. \n" +
                            "Resume checked MTX level per standard of care";
                } else {
                    if (mtxlvl >= 75 && mtxlvl < 100) {
                        System.out.println("Reduce rate by 20% of current Rate.");
                        System.out.println("Resume checked MTX level per standard of care.");
                        return "Reduce rate by 20% of current Rate. \n" +
                                "Resume checked MTX level per standard of care";
                    } else {
                        System.out.println("Stop infusion for 1 hr");
                        System.out.println("Restart at 50% reduction of current Rate");
                        System.out.println("Resume checked MTX level per standard of care");

                        return "Stop infusion for 1 hr. \n " +
                                "Restart at 50% reduction of current Rate. \n " +
                                "Resume checked MTX level per standard of care.";
                    }
                }
            default:
                return "MTX level time is out of algorithm's range. Please consult a provider.";
        }
    }
}



