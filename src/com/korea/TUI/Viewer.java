package com.korea.TUI;

import com.korea.controller.FrontController;
import com.korea.dto.AuthDTO;
import com.korea.dto.CarDTO;
import com.korea.dto.MemberDTO;
import com.korea.dto.RentDTO;
import com.korea.service.CarService;
import com.korea.view.SuperViewer;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Scanner;

public class Viewer implements SuperViewer
{
    Scanner sc = new Scanner(System.in);
    int num;
    ResultSet rs;

    FrontController controller = new FrontController();
    Viewer view = this;

    public void MainMenu()
    {
        while(true)
        {
            System.out.println("--------------메인--------------");
            System.out.println("1 회원로그인");
            System.out.println("2 직원로그인");
            System.out.println("3 회원가입");
            System.out.println("4 전체 차량 조회");
            System.out.println("5 차종 검색");
            System.out.println("6 종료");
            System.out.println("--------------메인--------------");
            System.out.print("번호: ");
            num = sc.nextInt();
            switch(num)
            {
                case 1: // 회원로그인
                    System.out.print("IDㅣPW > ");
                    String tmpid = sc.next();
                    String tmppw = sc.next();
                    AuthDTO dto = new AuthDTO(tmpid, tmppw);
                    boolean r1 = controller.SubControllerEX("Auth", 1, dto, view);
                    if(r1)
                    {
                        //인증성공 -> 회원메뉴 출력
                        System.out.println("로그인 성공!");
                        UserMenu(tmpid);
                    }
                    else
                    {
                        System.out.println("로그인 실패..");
                    }
                    break;
                case 2: // 직원로그인
                    System.out.print("IDㅣPW > ");
                    String tmpid2 = sc.next();
                    String tmppw2 = sc.next();
                    AuthDTO dto2 = new AuthDTO(tmpid2, tmppw2);
                    boolean r2 = controller.SubControllerEX("Auth", 2, dto2, view);
                    if(r2)
                    {
                        System.out.println("로그인 성공!");
                        EmployeeMenu();
                    }
                    else
                    {
                        System.out.println("로그인 실패..");
                    }
                    break;
                case 3: // 회원 회원가입
                    System.out.println("idㅣpwㅣ이름ㅣ나이ㅣ성별ㅣ전화번호");
                    System.out.print("> ");
                    String id = sc.next();
                    String pw = sc.next();
                    String name = sc.next();
                    int age = sc.nextInt();
                    String sex = sc.next();
                    String phone = sc.next();
                    System.out.println("주소ㅣ면허종류ㅣ면허번호ㅣ취득일ㅣ만료일");
                    System.out.print("> ");
                    String addr = sc.next();
                    String license = sc.next();
                    String license_num = sc.next();
                    Date license_start = Date.valueOf(sc.next());
                    Date license_end = Date.valueOf(sc.next());
                    MemberDTO dto3 = new MemberDTO(id, pw, name, age, sex, phone, addr, license, license_num, license_start, license_end);
                    boolean r3 = controller.SubControllerEX("Member", 1, dto3, view);
                    if(r3)
                    {
                        System.out.println("가입 성공!");
                    }
                    else
                    {
                        System.out.println("가입 실패");
                    }
                    break;
                case 4: // 전체차량조회
                    controller.SubControllerEX("Car", 1, null, view);
                    break;
                case 5: // 차량 검색
                    System.out.print("차종 입력 > ");
                    String Car_Name2 = sc.next();
                    CarDTO dto5 = new CarDTO(Car_Name2, 1);
                    controller.SubControllerEX("Car", 2, dto5, view);
                    break;
                case 6: // 종료
                    System.out.println("프로그램을 종료합니다");
                    System.exit(-1);
                default:
                    System.out.println("잘못입력하셨습니다..");
            }
        }
    }

    public void EmployeeMenu()
    {
        while(true)
        {
            System.out.println("--------------관리자 메뉴--------------");
            System.out.println("1 차량관리");
            System.out.println("2 회원관리");
            System.out.println("3 렌트관리");
            System.out.println("4 로그아웃");
            System.out.println("--------------관리자 메뉴--------------");
            System.out.print("번호: ");
            num = sc.nextInt();
            switch(num)
            {
                case 1:
                    CarManageMenu();
                    break;
                case 2:
                    MemberManageMenu();
                    break;
                case 3:
                    RentManageMenu();
                    break;
                case 4:
                    MainMenu();
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");
            }
        }
    }

    public void CarManageMenu()
    {
        while(true)
        {
            System.out.println("--------------차량 관리--------------");
            System.out.println("1 전체차량조회");
            System.out.println("2 차종별 검색");
            System.out.println("3 차량등록");
            System.out.println("4 차량정보수정");
            System.out.println("5 차량정보삭제");
            System.out.println("6 뒤로 가기");
            System.out.println("--------------차량 관리--------------");
            System.out.print("번호: ");
            num = sc.nextInt();
            switch(num)
            {
                case 1:
                    controller.SubControllerEX("Car", 1, null, view);
                    break;
                case 2:
                    System.out.print("차종 입력 > ");
                    String Car_Name2 = sc.next();
                    CarDTO dto2 = new CarDTO(Car_Name2, 1);
                    controller.SubControllerEX("Car", 2, dto2, view);
                    break;
                case 3:
                    System.out.print("차량번호ㅣ차종ㅣ인승ㅣ색상ㅣ가격 > ");
                    String Car_Code3 = sc.next();
                    String Car_Name3 = sc.next();
                    int Car_Person3 = sc.nextInt();
                    String Car_Color3 = sc.next();
                    int Car_Price3 = sc.nextInt();
                    CarDTO dto3 = new CarDTO(Car_Code3, Car_Name3, Car_Person3, Car_Color3, Car_Price3);
                    boolean result3 = controller.SubControllerEX("Car", 3, dto3, view);
                    if(result3)
                    {
                        System.out.println("등록 완료!");
                    }
                    else
                    {
                        System.out.println("등록 실패!");
                    }
                    break;
                case 4:
                    System.out.print("수정할 차량번호 > ");
                    String Car_Code4 = sc.next();
                    System.out.print("차종ㅣ인승ㅣ색상ㅣ가격 > ");
                    String Car_Name4 = sc.next();
                    int Car_Person4 = sc.nextInt();
                    String Car_Color4 = sc.next();
                    int Car_Price4 = sc.nextInt();
                    CarDTO dto4 = new CarDTO(Car_Code4, Car_Name4, Car_Person4, Car_Color4, Car_Price4);
                    boolean result4 = controller.SubControllerEX("Car", 4, dto4, view);
                    if(result4)
                    {
                        System.out.println("수정 완료!");
                    }
                    else
                    {
                        System.out.println("수정 실패!");
                    }
                    break;
                case 5:
                    System.out.print("삭제할 차량번호 > ");
                    String Car_Code5 = sc.next();
                    CarDTO dto5 = new CarDTO(Car_Code5);
                    boolean result5 = controller.SubControllerEX("Car", 5, dto5, view);
                    if(result5)
                    {
                        System.out.println("삭제 완료!");
                    }
                    else
                    {
                        System.out.println("삭제 실패!");
                    }
                    break;
                case 6:
                    EmployeeMenu();
                    break;
                default:
                    System.out.println("잘못입력하셨습니다.");
            }
        }
    }

    public void MemberManageMenu()
    {
        while(true)
        {
            System.out.println("--------------회원 관리--------------");
            System.out.println("1 전체회원조회");
            System.out.println("2 회원 검색");
            System.out.println("3 회원정보삭제");
            System.out.println("4 뒤로 가기");
            System.out.println("--------------회원 관리--------------");
            System.out.print("번호: ");
            num = sc.nextInt();
            switch(num)
            {
                case 1:
                    controller.SubControllerEX("Member", 2, null, view);
                    break;
                case 2:
                    System.out.print("회원 ID 입력 > ");
                    String Member_id2 = sc.next();
                    MemberDTO dto2 = new MemberDTO(Member_id2);
                    controller.SubControllerEX("Member", 3, dto2, view);
                    break;
                case 3:
                    System.out.print("삭제할 회원 ID 입력 > ");
                    String Member_id3 = sc.next();
                    MemberDTO dto3 = new MemberDTO(Member_id3);
                    boolean result3 = controller.SubControllerEX("Member", 5, dto3, view);
                    if(result3)
                    {
                        System.out.println("삭제 완료!");
                    }
                    else
                    {
                        System.out.println("삭제 실패!");
                    }
                    break;
                case 4:
                    EmployeeMenu();
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");
            }
        }

    }

    public void RentManageMenu()
    {
        while(true)
        {
            System.out.println("--------------렌트 관리--------------");
            System.out.println("1 전체렌트정보조회");
            System.out.println("2 회원 검색 조회");
            System.out.println("3 렌트 정보 수정");
            System.out.println("4 렌트 정보 삭제");
            System.out.println("5 뒤로 가기");
            System.out.println("--------------렌트 관리--------------");
            System.out.print("번호: ");
            num = sc.nextInt();
            switch(num)
            {
                case 1:
                    controller.SubControllerEX("Rent", 4, null, view);
                    break;
                case 2:
                    System.out.print("회원ID 입력 > ");
                    String user_id = sc.next();
                    RentDTO dto2 = new RentDTO(user_id);
                    controller.SubControllerEX("Rent", 3, dto2, view);
                    break;
                case 3:
                    System.out.print("수정할 렌트번호 > ");
                    int rent_code3 = sc.nextInt();
                    System.out.println("IDㅣ차량번호ㅣ렌트 시작일ㅣ렌트 종료일 > ");
                    String user_id3 = sc.next();
                    String car_code3 = sc.next();
                    Date start_date = Date.valueOf(sc.next());
                    Date end_date = Date.valueOf(sc.next());
                    rs = RentCheck(car_code3);
                    int price = 0;
                    try
                    {
                        while(rs.next())
                        {
                            price = rs.getInt("Car_Price");
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    int period = 1 + ((int) ((end_date.getTime() - start_date.getTime()) / 1000 / (24 * 60 * 60)));
                    price = period * price;
                    RentDTO dto3 = new RentDTO(rent_code3, user_id3, car_code3, start_date, end_date, period, price);
                    boolean result3 = controller.SubControllerEX("Rent", 6, dto3, view);
                    if(result3)
                    {
                        System.out.println("수정 완료!");
                    }
                    else
                    {
                        System.out.println("수정 실패!");
                    }
                    break;
                case 4:
                    System.out.print("삭제할 렌트번호 입력 > ");
                    int rent_code4 = sc.nextInt();
                    RentDTO dto4 = new RentDTO(rent_code4, 0, 0);
                    boolean result4 = controller.SubControllerEX("Rent", 5, dto4, view);
                    if(result4)
                    {
                        System.out.println("삭제 완료!");
                    }
                    else
                    {
                        System.out.println("삭제 실패!");
                    }
                    break;
                case 5:
                    EmployeeMenu();
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");

            }
        }
    }


    public void UserMenu(String id)
    {
        while(true)
        {
            System.out.println("--------------회원 메뉴--------------");
            System.out.println("1 차량 예약");
            System.out.println("2 마이페이지");
            System.out.println("3 로그아웃");
            System.out.println("--------------회원 메뉴--------------");
            System.out.print("번호: ");
            num = sc.nextInt();
            switch(num)
            {
                case 1:
                    RentMenu(id);
                    break;
                case 2:
                    Mypage(id);
                    break;
                case 3:
                    MainMenu();
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");
            }
        }
    }

    public void RentMenu(String id)
    {
        String Car_code;
        String Car_name = null;
        int Car_person = 0;
        String Car_color = null;
        int Car_price = 0;
        Date Rent_start = Date.valueOf("2022-03-24");
        Date Rent_End = Date.valueOf("2022-08-18");
        try
        {
            System.out.print("렌트 시작일을 입력해주세요 : ");
            Rent_start = Date.valueOf(sc.next());
            System.out.print("렌트 종료일을 입력해주세요 : ");
            Rent_End = Date.valueOf(sc.next());
        }
        catch(Exception e)
        {
            System.out.println("YYYY-MM-DD 에 맞춰서 입력해주세요!");
            UserMenu(id);
        }

        int period = 1 + ((int) ((Rent_End.getTime() - Rent_start.getTime()) / 1000 / (24 * 60 * 60)));
        RentDTO dto = new RentDTO(Rent_start, Rent_End);
        controller.SubControllerEX("Rent", 1, dto, view);
        System.out.println("-------------------------------------------------");
        System.out.print("렌트하고 싶은 차량의 번호를 입력해주세요 : ");
        Car_code = sc.next();
        rs = RentCheck(Car_code);
        try
        {
            while(rs.next())
            {
                Car_code = rs.getString("Car_Code");
                Car_name = rs.getString("Car_Name");
                Car_person = rs.getInt("Car_Person");
                Car_color = rs.getString("Car_Color");
                Car_price = rs.getInt("Car_Price");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        int price = period * Car_price;
        System.out.println("-------------예약 정보를 확인해주세요-------------");
        System.out.println("차량번호\t차종\t인승\t색상");
        System.out.println(Car_code + "\t" + Car_name + "\t" + Car_person + "\t" + Car_color);
        System.out.println("--------------------------------------------------");
        System.out.println("ID\t렌트 시작일\t렌트 종료일\t렌트비용");
        System.out.println("--------------------------------------------------");
        System.out.println(id + "\t" + Rent_start + "\t" + Rent_End + "\t" + price);
        while(true)
        {
            System.out.print("렌트 하시겠습니까? [Y/N] : ");
            String str = sc.next();
            if(str.equals("Y"))
            {
                RentDTO dto3 = new RentDTO(id, Car_code, Rent_start, Rent_End, period, price);
                boolean result = controller.SubControllerEX("Rent", 2, dto3, view);
                if(result)
                {
                    System.out.println("예약신청이 완료되었습니다.");
                    UserMenu(id);
                }
                else
                {
                    System.out.println("예약에 실패했습니다.");
                    UserMenu(id);
                    break;
                }
            }
            else if(str.equals("N"))
            {
                RentMenu(id);
                break;
            }
            else
            {
                System.out.println("Y 또는 N 만 입력가능합니다!");
            }
        }
    }

    public void Mypage(String id)
    {
        while(true)
        {
            System.out.println("--------------마이페이지--------------");
            System.out.println("1 내 정보 확인");
            System.out.println("2 내 정보 수정");
            System.out.println("3 내 렌트정보 확인");
            System.out.println("4 회원 탈퇴");
            System.out.println("5 뒤로 가기");
            System.out.println("--------------마이페이지--------------");
            System.out.print("번호: ");
            num = sc.nextInt();
            switch(num)
            {
                case 1:
                    MemberDTO dto = new MemberDTO(id);
                    controller.SubControllerEX("Member", 3, dto, view);
                    break;
                case 2:
                    System.out.println("pwㅣ이름ㅣ나이ㅣ성별ㅣ전화번호");
                    String Member_pw = sc.next();
                    String Member_name = sc.next();
                    int Member_age = sc.nextInt();
                    String Member_sex = sc.next();
                    String Member_phone = sc.next();
                    System.out.println("주소ㅣ면허종류ㅣ면허번호ㅣ취득일ㅣ만료일");
                    String Member_addr = sc.next();
                    String Member_license = sc.next();
                    String license_num = sc.next();
                    Date license_start = Date.valueOf(sc.next());
                    Date license_end = Date.valueOf(sc.next());
                    MemberDTO dto2 = new MemberDTO(id, Member_pw, Member_name, Member_age, Member_sex, Member_phone, Member_addr, Member_license, license_num, license_start, license_end);
                    controller.SubControllerEX("Member", 4, dto2, view);
                    System.out.println("수정 완료!");
                    break;
                case 3:
                    RentDTO dto3 = new RentDTO(id);
                    controller.SubControllerEX("Rent", 3, dto3, view);
                    break;
                case 4:
                    while(true)
                    {
                        System.out.print("정말 탈퇴하시겠습니까? [Y/N] : ");
                        String str = sc.next();
                        if(str.equals("Y"))
                        {
                            MemberDTO dto4 = new MemberDTO(id);
                            boolean result4 = controller.SubControllerEX("Member", 5, dto4, view);
                            if(result4)
                            {
                                System.out.println("그 동안 이용해주셔서 감사합니다");
                                MainMenu();
                            }
                            else
                            {
                                System.out.println("삭제 실패!");
                            }
                        }
                        else if(str.equals("N"))
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Y 또는 N 만 입력가능합니다!");
                        }
                    }
                    break;
                case 5:
                    UserMenu(id);
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다");
            }
        }
    }

    public ResultSet RentCheck(String Car_Code)
    {
        CarService service = new CarService();
        CarDTO dto = new CarDTO(Car_Code);
        try
        {
            rs = service.RentCheck(dto);
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}