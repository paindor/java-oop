package com.bitcamp.services;

import com.bitcamp.domains.MemberBean;;
public class MembersService {
/*
 * <사용자기능>
 * 요구사항
 * 1.회원가입
 * 2.마이페이지
 * 3. 비번수정
 * 4.회원탈퇴
 * -------------------------
 * <관리자기능>
 * 
 * 5.회원목록
 * 6.아이디검색
 * 
 * 
 * 
 * 
 * 
 */
	private MemberBean[] members;
	private int count;
	
	public MembersService() {
		this.members = new MemberBean[3];
		count = 0;
	}
	
	public String join(MemberBean param) {
		String result = "회원가입 성공";
		// 회원가입
		members[count] = param;
		this.count++;
		
		return result;
		
	}
	// 2. 마이페이지
	public String showMyPage(MemberBean param) {
		//String result = "마이 페이지";
		
		return param.tosString();
		
	}
	// 3.비번변경
	public String changePw(MemberBean param) {
		String result = "비번변경완료";
		
		return result;
		
	}
	//4 회원탈퇴
	public String withDraw(MemberBean param) {
		String result = "회원탈퇴 완료";
		return result;
		
	}
	//5회원목록
	public String list() {
		String msg = "";
		for(int i = 0 ;i <count ;i++) {
			msg += members[i].tosString()+ ", \n";
			
		}
		return msg;
		
	}
	//아이디찾기
	public MemberBean findById(String findId) {
		MemberBean member = new MemberBean();
		for(int i = 0 ;i < count ; i++) {
			if(members[i].getId().equals(findId) ) {
				member = members[i];
			}
		}
		return member;
		
	}
	
	
}
