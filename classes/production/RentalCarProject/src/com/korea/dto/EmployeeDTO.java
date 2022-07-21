package com.korea.dto;

public class EmployeeDTO extends DTO
{
    private String employee_id;
    private String employee_pw;
    private String employee_name;
    private int employee_age;
    private String employee_phone;
    private String employee_addr;
    private String employee_rank;

    public EmployeeDTO(String employee_id, String employee_pw, String employee_name, int employee_age, String employee_phone, String employee_addr, String employee_rank)
    {
        this.employee_id = employee_id;
        this.employee_pw = employee_pw;
        this.employee_name = employee_name;
        this.employee_age = employee_age;
        this.employee_phone = employee_phone;
        this.employee_addr = employee_addr;
        this.employee_rank = employee_rank;
    }

    public String getEmployee_id()
    {
        return employee_id;
    }

    public void setEmployee_id(String employee_id)
    {
        this.employee_id = employee_id;
    }

    public String getEmployee_pw()
    {
        return employee_pw;
    }

    public void setEmployee_pw(String employee_pw)
    {
        this.employee_pw = employee_pw;
    }

    public String getEmployee_name()
    {
        return employee_name;
    }

    public void setEmployee_name(String employee_name)
    {
        this.employee_name = employee_name;
    }

    public int getEmployee_age()
    {
        return employee_age;
    }

    public void setEmployee_age(int employee_age)
    {
        this.employee_age = employee_age;
    }

    public String getEmployee_phone()
    {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone)
    {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_addr()
    {
        return employee_addr;
    }

    public void setEmployee_addr(String employee_addr)
    {
        this.employee_addr = employee_addr;
    }

    public String getEmployee_rank()
    {
        return employee_rank;
    }

    public void setEmployee_rank(String employee_rank)
    {
        this.employee_rank = employee_rank;
    }

    @Override
    public String toString()
    {
        return "EmployeeDTO{" + "employee_id='" + employee_id + '\'' + ", employee_pw='" + employee_pw + '\'' + ", employee_name='" + employee_name + '\'' + ", employee_age=" + employee_age + ", employee_phone='" + employee_phone + '\'' + ", employee_addr='" + employee_addr + '\'' + ", employee_rank='" + employee_rank + '\'' + '}';
    }
}
