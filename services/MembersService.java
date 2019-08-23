package com.bitcamp.services;

import javax.swing.JOptionPane;

import com.bitcamp.domains.MemberBean;;
public class MembersService {
/*
 * <사용자기능>
 * 요구사항
 * 1.회원가입
 * 2.마이페이지
 * 3. 비번수정
 * 4.회원탈퇴
 * 5.아이디체크
 * 6.로그인
 * 
 * -------------------------
 * <관리자기능>
 * 
 * 5.회원목록
 * 6.아이디검색
 * 7 이름검색
 * 
 * 
 * 
 * 
 * 
 */
	private MemberBean[] members;
	private int count;
	
	public MembersService() {
		this.members = new MemberBean[10];
		count = 0;
	}
	//회원가입
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
	// 3.비번변경( 옛날 비번, 신규비번 입력받아서 옛날비번체크 일치하면 신규비번으로 변경)
	// 비번변경후 로그인을 실행 새로 바뀐비번 = 로그인성공 옛날버전은 로그인실패
	
	public String changePw(MemberBean param) {
		String result = "비번변경완료";
		String apw = param.getPw();
		String[] pws = apw.split(",");
		System.out.println(apw);
		String oldpw = pws[0];
		String newpw = pws[1];
		
		for( int i= 0; i < count ; i++) {
			
			if(param.getId().equals(members[i].getId())) {
				if(oldpw.equals(members[i].getPw())) {
					members[i].setPw(newpw);
					MemberBean login = new MemberBean();
					login.setId(members[i].getId());
					login.setPw(newpw);
					String log = this.login(login);
					JOptionPane.showMessageDialog(null, log);
					break;
				}
			}
			else {
				result = "입력오류";
			}
			
			
		}
		
		return result;
		
	}
	//4 회원탈퇴
	public String withDraw(MemberBean param) {
		String result = "회원탈퇴 완료";
		return result;
		
	}
	//아이디체크
	public String existId(String id) {
		String msg = "가입가능한 아이디입니다.";
		for(int i = 0 ; i < members.length; i++) {
			if(id.equals(members[i].getId())){
				{
					msg = "가입된아이디";
					break;
				}
			}
		}
		
		
		
		return msg;
		
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
				break;
				
			}
		}
		return member;
		
	}
	// 6 로그인
	public String login(MemberBean mem) {
		String msg = "로그인실패";
		for(int i = 0 ; i < count ; i++) {
			if(mem.getId().equals(members[i].getId()) && 
					mem.getPw().equals(members[i].getPw())) {
					msg = "로그인성공";
					break;
					
				
			}
		}
		return msg;
		
	}
	// 이름검색
	public MemberBean[] findByName(String name) {
		
		int max = 0;
		int cc = 0;
		for(int i = 0;i < count ; i++) {
			if(name.equals(this.members[i].getName())) {
				
				max++;
			}
			
		}
		MemberBean[] mems = new MemberBean[max];
		
		for(int i = 0 ;i < count ; i++) {
				if(name.equals(this.members[i].getName())) {
				mems[cc] = this.members[i];
				System.out.println(members[i].getHeight());
				cc++;
					if(cc == max) {
						break;
					
					}
				}
			}
		for(int i = 0 ;i < mems.length;i++) {
			System.out.println(mems[i].getName());
		}
		return mems;
	}
	public String getNumAllJoiner() {
		String result = String.valueOf(count);
		
		return result;
		
		
	}
	
}
