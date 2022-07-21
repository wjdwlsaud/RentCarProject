package com.korea.dto;

import java.sql.Date;

public class RentDTO extends DTO
{
    private int Rent_code;
    private String Member_id;
    private String Car_code;
    private Date Start_Date;
    private Date End_Date;
    private int Period;
    private int Price;

    public RentDTO(int rent_code, String member_id, String car_code, Date start_Date, Date end_Date, int period, int price)
    {
        Rent_code = rent_code;
        Member_id = member_id;
        Car_code = car_code;
        Start_Date = start_Date;
        End_Date = end_Date;
        Period = period;
        Price = price;
    }

    public RentDTO(String member_id, String car_code, Date start_Date, Date end_Date, int period, int price)
    {
        Member_id = member_id;
        Car_code = car_code;
        Start_Date = start_Date;
        End_Date = end_Date;
        Period = period;
        Price = price;
    }

    public RentDTO(Date Start_Date, Date End_Date)
    {
        this.Start_Date = Start_Date;
        this.End_Date = End_Date;
    }

    public RentDTO(int Rent_Code, int i, int j)
    {
        this.Rent_code = Rent_Code;
    }

    public RentDTO(String Member_id)
    {
        this.Member_id = Member_id;
    }

    public int getRent_code()
    {
        return Rent_code;
    }

    public void setRent_code(int rent_code)
    {
        Rent_code = rent_code;
    }

    public String getMember_id()
    {
        return Member_id;
    }

    public void setMember_id(String member_id)
    {
        Member_id = member_id;
    }

    public String getCar_code()
    {
        return Car_code;
    }

    public void setCar_code(String car_code)
    {
        Car_code = car_code;
    }

    public Date getStart_Date()
    {
        return Start_Date;
    }

    public void setStart_Date(Date start_Date)
    {
        Start_Date = start_Date;
    }

    public Date getEnd_Date()
    {
        return End_Date;
    }

    public void setEnd_Date(Date end_Date)
    {
        End_Date = end_Date;
    }

    public int getPeriod()
    {
        return Period;
    }

    public void setPeriod(int period)
    {
        Period = period;
    }

    public int getPrice()
    {
        return Price;
    }

    public void setPrice(int price)
    {
        Price = price;
    }

    @Override
    public String toString()
    {
        return "RentDTO{" + "Rent_code=" + Rent_code + ", Member_id='" + Member_id + '\'' + ", Car_code='" + Car_code + '\'' + ", Start_Date=" + Start_Date + ", End_Date=" + End_Date + ", Period=" + Period + ", Price=" + Price + '}';
    }
}
