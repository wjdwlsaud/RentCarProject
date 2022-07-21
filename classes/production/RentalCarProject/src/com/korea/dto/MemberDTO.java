package com.korea.dto;

import java.sql.Date;

public class MemberDTO extends DTO
{
    private String member_id;
    private String member_pw;
    private String member_name;
    private int member_age;
    private String member_sex;
    private String member_phone;
    private String member_addr;
    private String member_license;
    private String license_num;
    private Date license_start;
    private Date license_end;

    public MemberDTO(String member_id)
    {
        this.member_id = member_id;
    }

    public MemberDTO(String member_id, String member_pw, String member_name, int member_age, String member_sex, String member_phone, String member_addr, String member_license, String license_num, Date license_start, Date license_end)
    {
        this.member_id = member_id;
        this.member_pw = member_pw;
        this.member_name = member_name;
        this.member_age = member_age;
        this.member_sex = member_sex;
        this.member_phone = member_phone;
        this.member_addr = member_addr;
        this.member_license = member_license;
        this.license_num = license_num;
        this.license_start = license_start;
        this.license_end = license_end;
    }

    public String getMember_id()
    {
        return member_id;
    }

    public void setMember_id(String member_id)
    {
        this.member_id = member_id;
    }

    public String getMember_pw()
    {
        return member_pw;
    }

    public void setMember_pw(String member_pw)
    {
        this.member_pw = member_pw;
    }

    public String getMember_name()
    {
        return member_name;
    }

    public void setMember_name(String member_name)
    {
        this.member_name = member_name;
    }

    public int getMember_age()
    {
        return member_age;
    }

    public void setMember_age(int member_age)
    {
        this.member_age = member_age;
    }

    public String getMember_sex()
    {
        return member_sex;
    }

    public void setMember_sex(String member_sex)
    {
        this.member_sex = member_sex;
    }

    public String getMember_phone()
    {
        return member_phone;
    }

    public void setMember_phone(String member_phone)
    {
        this.member_phone = member_phone;
    }

    public String getMember_addr()
    {
        return member_addr;
    }

    public void setMember_addr(String member_addr)
    {
        this.member_addr = member_addr;
    }

    public String getMember_license()
    {
        return member_license;
    }

    public void setMember_license(String member_license)
    {
        this.member_license = member_license;
    }

    public String getLicense_num()
    {
        return license_num;
    }

    public void setLicense_num(String license_num)
    {
        this.license_num = license_num;
    }

    public Date getLicense_start()
    {
        return license_start;
    }

    public void setLicense_start(Date license_start)
    {
        this.license_start = license_start;
    }

    public Date getLicense_end()
    {
        return license_end;
    }

    public void setLicense_end(Date license_end)
    {
        this.license_end = license_end;
    }

    @Override
    public String toString()
    {
        return "MemberDTO{" + "member_id='" + member_id + '\'' + ", member_pw='" + member_pw + '\'' + ", member_name='" + member_name + '\'' + ", member_age=" + member_age + ", member_sex='" + member_sex + '\'' + ", member_phone='" + member_phone + '\'' + ", member_addr='" + member_addr + '\'' + ", member_license='" + member_license + '\'' + ", license_num='" + license_num + '\'' + ", license_start=" + license_start + ", license_end=" + license_end + '}';
    }
}
