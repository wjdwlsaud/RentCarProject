package com.korea.controller;

import com.korea.dto.CarDTO;
import com.korea.dto.DTO;
import com.korea.service.CarService;
import com.korea.view.SuperViewer;

public class CarController implements SubController
{
    CarService service = new CarService();

    @Override
    public boolean execute(int num, DTO dto, SuperViewer view)
    {
        CarDTO cdto = (CarDTO) dto;
        if(num == 1)
        {
            return service.Select(cdto, view);
        }
        else if(num ==2)
        {
            return service.SelectSearch(cdto, view);
        }
        else if(num == 3)
        {
            return service.Insert(cdto);
        }
        else if(num == 4)
        {
            return service.Update(cdto);
        }
        else if(num == 5)
        {
            return service.Delete(cdto);
        }
        return false;
    }
}
