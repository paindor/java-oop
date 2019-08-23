package com.bitcamp.Controllers;
import javax.swing.JOptionPane;
import com.bitcamp.domains.*;
import com.bitcamp.services.*;
public class AdminController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberBean[] mems = null;
		
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n"
					+ "1.회원목록\n"
					+ "2.아이디검색\n"
					+ "3.이름검색\n")){
			case "0":
				String n = ms.list();
				break;
			case "1":
				break;
			case "2":
				String name = JOptionPane.showInputDialog("이름입력");
				mems = new MemberBean[2];
				//mems = ms.findByName(name);
				System.out.println(name);
				for(int i = 0 ; i < mems.length; i++) {
					System.out.println(mems[i].getId());
				}
				break;
				
			
				
			}
		}
	}

}
