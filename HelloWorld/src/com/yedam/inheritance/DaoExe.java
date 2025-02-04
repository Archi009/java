package com.yedam.inheritance;

import java.util.Scanner;

/*
 * 실행 클래스 (main)
 * mysql 
 * oracle
 */

public class DaoExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
//		MysqlDao dao = new MysqlDao();
		MysqlDao daoAb = new MysqlDao();
		OracleDao daoAbo = new OracleDao();
//		OracleDao dao = new OracleDao();
//		=>이렇게 일일히 객체마다 다른이름 같은 기능의 메소드들이 중구난방으로 쓰여져 
//		기능을 사용할때마다 어떤기능인지 추론해야하고, 유지보수(코드수정)할때 찾아야할게 많아진다
		while (run) {
			System.out.println("1.등록 2.삭제 3.조회 9.종료");
			System.out.print("선택 >>>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				daoAb.register();
				daoAbo.register();
//				dao.insert();MysqlDao
//				dao.add();oracle
				break;
			case 2:
				daoAb.remove();
				daoAbo.remove();
//				dao.delete();MysqlDao
//				dao.remove();oracle
				break;
			case 3:
				daoAb.search();
				daoAbo.search();
//				dao.search();MysqlDao
//				dao.select();oracle
				break;
			case 9:
				run = false;
				break;
			default:
				break;
			}

		}
	}
}
