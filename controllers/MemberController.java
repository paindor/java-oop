package com.bitcamp.controllers;

import javax.swing.JOptionPane;
/**
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 마이페이지
 * 3. 비번 수정
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * 6. 로그인
 * **********
 * <관리자기능>
 * 1. 회원목록
 * 2. 아이디검색
 * 3. 이름검색
 * 4. 전체 회원수
 * 
 * */
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;
public class MemberController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberBean mem = null;
		MemberService ms = new MemberService();
		
		while(true) {
			switch(JOptionPane.showInputDialog("0종료"
					+ "1.회원가입\n"
					+ "2.마이페이지\n"
					+ "3.비번변경\n"
					+ "4. 회원탈퇴\n"
					+ "5. 아이디체크\n"
					+ "6.로그인\n"
					+ "관리자기능 \n"
					+ "7. 회원목록\n"
					+ "8.아이디검색\n"
					+ "9.이름검색\n"
					+ "10.회원수")) {
			case "0":return;
			case "1": //회원가입
				mem = new MemberBean();
				String name = JOptionPane.showInputDialog("아이디,pw,이름");
				String[] arr = name.split(",");
				mem.setId(arr[0]);
				mem.setPw(arr[1]);
				mem.setName(arr[2]);
				JOptionPane.showMessageDialog(null, ms.join(mem));
				
				break;
			case "2": //mypage
				String result = JOptionPane.showInputDialog(ms.showMyPage(mem));
				
				break;
			case "3": //chang pw'
				name = JOptionPane.showInputDialog("아이디,비밀번호,변경비밀번호");
				arr = name.split(",");
				mem.setId(arr[0]);
				mem.setPw(arr[1] + "," + arr[2]);
				result = JOptionPane.showInputDialog(ms.changePw(mem));
						
				break;
				
			case "4": //withdraw
				String idpw = JOptionPane.showInputDialog("아이디,비비밀번호");
				arr = idpw.split(",");
				mem.setId(arr[0]);
				mem.setPw(arr[1]);
				
				result = JOptionPane.showInputDialog(ms.withDraw(mem));
				
				break;
			case "5":  //check id
				name = JOptionPane.showInputDialog("아이디입력");
				result = JOptionPane.showInputDialog(ms.exsitId(name));
				
				break;
			case "6": //login
				name = JOptionPane.showInputDialog("id,pw");
				arr = name.split(",");
				mem.setId(arr[0]);
				mem.setPw(arr[1]);
				
				result = JOptionPane.showInputDialog(ms.login(mem));
				break;
			case "7": //all list
				JOptionPane.showMessageDialog(null,ms.showList());
				break;
			case "8": //find id
				name = JOptionPane.showInputDialog("id입력");
				result = JOptionPane.showInputDialog(ms.findById(name));
				break;
				
			case "9": //find name
				MemberBean[] mems = new MemberBean[3];
				name = JOptionPane.showInputDialog("이름입력");
				mems = ms.findByName(name);
				
				break;
			case "10": //all joniers
				result = JOptionPane.showInputDialog(ms.showAllMembers());
				
				break;
			}
		}
	}

}
