package com.korea.dto;

public class CarDTO extends DTO
{
    private String Car_Code;
    private String Car_Name;
    private int Car_Person;
    private String Car_Color;
    private int Car_Price;

    public CarDTO(String car_Code, String car_Name, int car_Person, String car_Color, int car_Price)
    {
        Car_Code = car_Code;
        Car_Name = car_Name;
        Car_Person = car_Person;
        Car_Color = car_Color;
        Car_Price = car_Price;
    }

    public CarDTO(String car_code)
    {
        Car_Code = car_code;
    }

    public CarDTO(String car_name, int i)
    {
        Car_Name = car_name;
    }

    public String getCar_Code()
    {
        return Car_Code;
    }

    public void setCar_Code(String car_Code)
    {
        Car_Code = car_Code;
    }

    public String getCar_Name()
    {
        return Car_Name;
    }

    public void setCar_Name(String car_Name)
    {
        Car_Name = car_Name;
    }

    public int getCar_Person()
    {
        return Car_Person;
    }

    public void setCar_Person(int car_Person)
    {
        Car_Person = car_Person;
    }

    public String getCar_Color()
    {
        return Car_Color;
    }

    public void setCar_Color(String car_Color)
    {
        Car_Color = car_Color;
    }

    public int getCar_Price()
    {
        return Car_Price;
    }

    public void setCar_Price(int car_Price)
    {
        Car_Price = car_Price;
    }

    @Override
    public String toString()
    {
        return "CarDTO{" + "Car_Code='" + Car_Code + '\'' + ", Car_Name='" + Car_Name + '\'' + ", Car_Person=" + Car_Person + ", Car_Color='" + Car_Color + '\'' + ", Car_Price=" + Car_Price + '}';
    }
}