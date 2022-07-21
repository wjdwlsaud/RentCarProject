package com.korea.controller;

import com.korea.dto.DTO;
import com.korea.dto.RentDTO;
import com.korea.service.RentService;
import com.korea.view.SuperViewer;

public class RentController implements SubController
{
    RentService service = new RentService();
    @Override
    public boolean execute(int num, DTO dto, SuperViewer view)
    {
        RentDTO rdto = (RentDTO) dto;
        if(num == 1)
        {
            return service.CarSearch(rdto, view);
        }
        else if(num == 2)
        {
            return service.Insert(rdto);
        }
        else if(num == 3)
        {
            return service.SelectSearch(rdto, view);
        }
        else if(num == 4)
        {
            return service.Select(rdto, view);
        }
        else if(num ==5)
        {
            return service.Delete(rdto);
        }
        else if(num ==6)
        {
            return service.Update(rdto);
        }
        return false;
    }
}
