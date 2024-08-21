package com.example.mtx_algor2.Model;


//import org.antlr.v4.runtime.misc.NotNull;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

//@Table
//@Entity
public class Patient {

    @NotNull(message="Infusion date is required")
    private LocalDate infusionStartDate;
    @NotNull(message="Infusion time is required")
    private LocalTime infusionStartTime;
    @NotNull(message="MTX time is required")
    private LocalTime mtx_checkTime = null;
    @NotNull(message = "MTX date is required")
    private LocalDate mtx_checkDate = null;
    @NotNull(message = "MTX level is required")
    private String mtxlvl;

    public LocalDate getInfusionStartDate() {
        return infusionStartDate;
    }

    public void setInfusionStartDate(LocalDate infusionStartDate) {
        this.infusionStartDate = infusionStartDate;
    }

    public LocalTime getInfusionStartTime() {
        return infusionStartTime;
    }

    public void setInfusionStartTime(LocalTime infusionStartTime) {
        this.infusionStartTime = infusionStartTime;
    }

    public LocalTime getMtx_checkTime() {
        return mtx_checkTime;
    }

    public void setMtx_checkTime(LocalTime mtx_checkTime) {
        this.mtx_checkTime = mtx_checkTime;
    }

    public LocalDate getMtx_checkDate() {
        return mtx_checkDate;
    }

    public void setMtx_checkDate(LocalDate mtx_checkDate) {
        this.mtx_checkDate = mtx_checkDate;
    }

    public String getMtxlvl() {
        return mtxlvl;
    }

    public void setMtxlvl(String mtxlvl) {
        this.mtxlvl = mtxlvl;
    }

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" +
                "infusionStartDate=" + infusionStartDate +
                ", infusionStartTime=" + infusionStartTime +
                ", mtx_checkTime=" + mtx_checkTime +
                ", mtx_checkDate=" + mtx_checkDate +
                ", mtxlvl='" + mtxlvl + '\'' +
                '}';
    }

}
