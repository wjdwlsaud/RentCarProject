package com.korea.controller;

import com.korea.dto.AuthDTO;
import com.korea.dto.DTO;
import com.korea.service.AuthService;
import com.korea.view.SuperViewer;

public class AuthController implements SubController
{
    AuthService service = new AuthService();
    @Override
    public boolean execute(int num, DTO dto, SuperViewer view)
    {
        AuthDTO adto = (AuthDTO) dto; // 다운캐스팅

        if(num == 1)
        {
            //회원로그인
            return service.MemberLogin(adto);
        }
        else if(num == 2)
        {
            //직원로그인
            return service.EmployeeLogin(adto);
        }
        return false;
    }
}