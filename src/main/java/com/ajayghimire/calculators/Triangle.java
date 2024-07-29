package com.ajayghimire.calculators;

public class Triangle {

  private double sideA;
  private double sideB;


  public Triangle() {
    this.sideA = 0.0;
    this.sideB = 0.0;
  }

  public String getSideA() {
    return Double.toString(sideA);
  }

  public void setSideA(String sideA) {
    try {
      this.sideA = Double.parseDouble(sideA);
    } catch (Exception e) {
      this.sideA = 0.0;
    }

  }

  public String getSideB() {
    return Double.toString(sideB);
  }

  public void setSideB(String sideB) {
    try {
      this.sideB = Double.parseDouble(sideB);
    } catch (Exception e) {
      this.sideB = 0.0;
    }
  }

  public String getSideC() {
    if (this.sideA == 0.0 || this.sideB == 0) {
      return "Please enter both side";
    } else {
      Double sideC;
      sideC = Math.sqrt((this.sideA * this.sideA) + (this.sideB * this.sideB));
      return Double.toString(sideC);
    }


  }

}
