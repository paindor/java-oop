package com.bitcamp.services;
import java.lang.reflect.Member;

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
import com.bitcamp.domains.*;
public class MemberService {
	
	private MemberBean[] mems;
	private int count;
	
	public MemberService() {
		mems = new MemberBean[10];
		count = 0;
				
	}
	//회원가입
	public String join(MemberBean mem ) {
		String msg = "회원가입완료";
		mems[count] = mem;
		count++;
		for(int i = 0 ; i < count; i++) {
			System.out.println(mems[i].getName() + "  ");
		}
		
		return msg;
		
	}
	//마이페이지
	public String showMyPage(MemberBean mem) {
		
		return mem.toString();
		
	}
	//비번변경
	// 비번 수정(ID, 옛날비번, 신규비번 입력받아서 옛날비번을 체크 후 일치하면 신규비번으로 변경 )
	// *  비번변경후 로그인을 실행해서 새로 바뀐 비번이 로그인 성공, 옛날비번 로그인 실패
	public String changePw(MemberBean mem) {
		String msg ="변경완료";
		String temp[] = mem.getPw().split(",");
		
		for( int i = 0 ;i < count ;i++) {
			if(mem.getId().equals(mems[i].getId())){
				if(temp[0].equals(mems[i].getPw())) {
					mems[i].setPw(temp[1]);
					
					break;
				}
			}
			msg = "잘못된입력";
		}
		
		
		return msg;
		
	}
	//회원탈퇴
	public String withDraw(MemberBean meme) {
		String msg = "탈퇴완료";
		int temp  = 0;
		
		for( int i = 0 ;i < count; i++) {
			if(meme.getId().equals(mems[i].getId())) {
				mems[i] = new MemberBean();
				break;
				
			}
			
			
		}
		MemberBean[] tempMem = new MemberBean[count-1];
		temp = 0;
		for(int i = 0 ;i  < count; i++) {
			if(mems[i].getId() != "") {
				tempMem[temp] = mems[i];
				temp++;
				if(temp == count-1) {
					break;
					
				}
				
			}
			
		}
		count--;
		for(int i = 0 ; i < count; i++) {
			mems[i] = tempMem[i];
			
		}
		
		
		
		return msg;
		
	}
	
	//아이디중복체크
	public String exsitId(String id) {
		String msg = "사용가능";
		for(int i = 0 ; i< count ; i++) {
			if(id.equals(mems[i].getId())) {
				msg = "사용중";
				break;
			}
			
		}
		return msg;
		
	}
	//로그인
	public String login(MemberBean mem) {
		String msg = "로그인실패";
		for(int i = 0 ; i< count; i++) {
			if(mem.getId().equals(mems[i].getId()) && mem.getPw().equals(mems[i].getPw())) {
				msg = "로그인성공";
				break;
			}
			
			
		}
		
		return msg;
		
	}
	//======================================================================================
	//
	//
	//회원목록
	public String showList() {
		String msg ="";
		for(int i = 0 ; i < count; i++) {
			msg += mems[i].toString() + "/\n ";
			
		}
		
		return msg;
		
	}
	//아이디검색
	public MemberBean findById(String id) {
		MemberBean mem = new MemberBean();
		for(int i = 0 ; i< count; i++) {
			if(id.equals(mems[i].getId())) {
				mem = mems[i];
				
			}
		}
		
		return mem;
		
	}
	
	//이름검색
	public MemberBean[] findByName(String name) {
		MemberBean[] mems = null;
		int max = 0;
		int tempCount = 0;
		
		for(int i = 0; i< count; i++) {
			if(name.equals(this.mems[i].getName())) {
				tempCount ++;
				
			}
		}
		mems = new MemberBean[tempCount];
		tempCount = 0;
		for(int i = 0 ; i< count; i++) {
			if(name.equals(this.mems[i].getName())) {
				mems[tempCount] = this.mems[i];
				tempCount++;
				if(tempCount == mems.length) {
					break;
					
				}
			}
		}
		
		
		
		return mems;
	}
	//회원수
	public String showAllMembers() {
		String msg = "";
		
		msg = "회원수 " + this.count ;
		
		return msg;
		
	}
	

}
