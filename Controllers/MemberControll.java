package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.services.MemberService;
import com.bitcamp.domains.MemberBean;
public class MemberControll {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberService ms = new MemberService();
		MemberBean mb = null;
		
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n" 
					+ "1.회원가입\n"
					+ "2.마이페이지\n"
					+ "3.비밀번호변경\n"
					+ "4.회원탈퇴\n"
					+ "5.회원목록\n"
					+ "6.아이디검색")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
			case "1":
				//id, pw, name, ssn, blood
				String spc = JOptionPane.showInputDialog("아이디/비밀번호/이름/주민번호/혈액형/키/몸무게");
				String[] arr = spc.split("/");
				mb = new MemberBean();
				mb.setId(arr[0]);
				mb.setPw(arr[1]);
				mb.setName(arr[2]);
				mb.setSsn(arr[3]);
				mb.setBlood(arr[4]);
				mb.setHeight(Double.parseDouble(arr[5]));
				mb.setWeight(Double.parseDouble(arr[6]));
				JOptionPane.showMessageDialog(null,ms.join(mb));
				
				
				
				
				break;
			case "2":
				JOptionPane.showMessageDialog(null, ms.showMypage(mb));
				break;
			case "3":
				
				//JOptionPane.showInputDialog()
				break;
			case "4":
				break;
			case "5":
				JOptionPane.showMessageDialog(null, ms.myList());
				break;
			case "6":
				String id = JOptionPane.showInputDialog("id입력");
				mb = ms.searchId(id);
				
				JOptionPane.showMessageDialog(null, mb.tosString());
				//System.out.println(mb.tosString());
				
				break;
			}
		}
	}

}
