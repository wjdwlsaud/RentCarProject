package com.korea.dto;

public class AuthDTO extends DTO
{
    private String id;
    private String pw;

    public AuthDTO(String id, String pw)
    {
        this.id = id;
        this.pw = pw;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPw()
    {
        return pw;
    }

    public void setPw(String pw)
    {
        this.pw = pw;
    }

    @Override
    public String toString()
    {
        return "AuthDTO{" + "id='" + id + '\'' + ", pw='" + pw + '\'' + '}';
    }
}
