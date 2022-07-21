package com.korea.controller;

import com.korea.dto.DTO;
import com.korea.dto.MemberDTO;
import com.korea.service.MemberService;
import com.korea.view.SuperViewer;

public class MemberController implements SubController
{
    MemberService service = new MemberService();
    @Override
    public boolean execute(int num, DTO dto, SuperViewer view)
    {
        MemberDTO mdto = (MemberDTO) dto;

        if(num == 1)
        {
            return service.MemberSignUp(mdto);
        }
        else if(num == 2)
        {
            return service.MemberSelect(mdto, view);
        }
        else if(num == 3)
        {
            return service.MemberSearch(mdto, view);
        }
        else if(num == 4)
        {
            return service.MemberUpdate(mdto);
        }
        else if(num == 5)
        {
            return service.MemberDelete(mdto);
        }
        return false;
    }
}
