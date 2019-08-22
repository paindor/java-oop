package com.bitcamp.services;


import com.bitcamp.domains.MemberBean;
public class MemberService {
	private MemberBean[] mbs;
	int count;
	public MemberService() {
		mbs = new MemberBean[10];
		count = 0;
		
	}
	public String join(MemberBean mb) {
		String result = "회원가입 완료";
		mbs[count] = mb;
		count++;
		
		return result;
		
	}
	
	// 마이페이지
	public String showMypage(MemberBean mem) {
				
		return mem.tosString();
		
	}
	//비밀번호 변경
	public String changePassword(MemberBean mem) {
		String msg = "비밀번호 변경완료";
		for( int i = 0 ; i<count ; i++) {
			if(mem.equals(mbs[i])) {
				return msg;
			}
		}
		
		return "정보없음";
		
		
	}
	
	//회원탈퇴
	public String withDraw(MemberBean mem) {
		String msg = "회원탈퇴완료";
		for(int i = 0 ; i< count ; i++) {
			if(mem.equals(mbs[i])) {
				mbs[i] = new MemberBean();
				return msg;
			}
		}
		
		return "회원정보없음";
		
		
		
	}
	//회원목록
	public String myList() {
		String msg  = "";
		for(int i = 0 ; i < count; i++) {
			msg += mbs[i].tosString() +"\n";
			
		}
		return msg;
		
	}
	//아이디검색
	public MemberBean searchId(String search) {
		MemberBean mb = new MemberBean();
		for(int i = 0 ; i<count ;i++) {
			if(search.equals(mbs[i].getId())) {
				mb = mbs[i];
				
			}
		}
		
		return mb;
		
	}
	

	
}
