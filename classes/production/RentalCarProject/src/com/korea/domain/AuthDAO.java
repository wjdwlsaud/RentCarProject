package com.korea.domain;

import com.korea.dto.AuthDTO;

public class AuthDAO extends DAO
{
    public AuthDAO()
    {
    }

    //회원로그인(num = 1)
    public boolean MemberLogin(AuthDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("select member_id,member_pw from member_tbl where member_id=?");
            pstmt.setString(1, dto.getId());
            rs = pstmt.executeQuery();

            String tid = null;
            String tpw = null;
            while(rs.next())
            {
                tid = rs.getString("member_id");
                tpw = rs.getString("member_pw");
            }
            //검증
            if(tid != null && tpw != null)
            {
                if(tid.equals(dto.getId()) && tpw.equals(dto.getPw()))
                {
                    return true;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    //직원로그인(num = 2)
    public boolean EmployeeLogin(AuthDTO dto)
    {
        try
        {
            pstmt = conn.prepareStatement("select Employee_id,Employee_pw from employee_tbl where Employee_id=?");
            pstmt.setString(1, dto.getId());
            rs = pstmt.executeQuery();

            String tid = null;
            String tpw = null;
            while(rs.next())
            {
                tid = rs.getString("employee_id");
                tpw = rs.getString("employee_pw");
            }
            //검증
            if(tid != null && tpw != null)
            {
                if(tid.equals(dto.getId()) && tpw.equals(dto.getPw()))
                {
                    return true;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                pstmt.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
}
