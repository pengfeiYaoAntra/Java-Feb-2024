package com.training.demo.entities;

import lombok.*;

import javax.swing.plaf.PanelUI;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calresult {

    private double result;


    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "My Calculator result is {" + result + "}";
    }
}
