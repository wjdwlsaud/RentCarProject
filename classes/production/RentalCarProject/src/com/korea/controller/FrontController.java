package com.korea.controller;

import java.util.HashMap;
import java.util.Map;

import com.korea.dto.DTO;
import com.korea.view.SuperViewer;


public class FrontController
{
    Map<String, SubController> map = new HashMap();

    public FrontController()
    { //업캐스팅
        Init();
    }

    void Init()
    {
        map.put("Car", new CarController());
        map.put("Auth", new AuthController());
        map.put("Member", new MemberController());
        map.put("Rent", new RentController());
    }

    public boolean SubControllerEX(String menu, int num, DTO dto, SuperViewer view)
    {
        if(menu.equals("Car"))
        {
            SubController sub = map.get("Car");
            return sub.execute(num, dto, view);
        }
        else if(menu.equals("Auth"))
        {
            SubController sub = map.get("Auth");
            return sub.execute(num, dto, view);
        }
        else if(menu.equals("Member"))
        {
            SubController sub = map.get("Member");
            return sub.execute(num, dto, view);
        }
        else if(menu.equals("Rent"))
        {
            SubController sub = map.get("Rent");
            return sub.execute(num, dto, view);
        }
        return false;
    }
}
