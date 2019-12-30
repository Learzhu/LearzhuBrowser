package com.learzhu.browser.test.json;

public class Car {
    private String brand = null;
    private String doors = "0";

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//    public int getDoors() {
//        try {
//            return Integer.parseInt(this.doors);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }

//    public void setDoors(String doors) {
//        this.doors = doors;
//    }

//    public void setDoors(int doors) {
//        this.doors = String.valueOf(doors);
//    }


    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }
}
