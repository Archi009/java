package com.yedam.stream;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.inheritance.CastingExe;

public class StudentApp {
	Scanner scn = new Scanner(System.in);
	boolean run = true;
	List<Student> students = new ArrayList<Student>();

	String name;
	double height;
	double weight;
	int scoure;

	public StudentApp() {
		init();
	}

	public void start() {
		while (run) {
			System.out.println("학생관리 프로그램");
			System.out.println("1.학생추가 2.정보수정 3.정보삭제 4.정보조회 9.프로그램 종료");
			System.out.println("선택 >> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
//					학생추가
				register();
				break;
			case 2:
//					정보수정
				editStu();
				break;
			case 3:
//					정보삭제
				removeStu();
				break;
			case 4:
//					정보조회
				search();
				break;
			case 9:
//					종료
				save();
				System.out.println("프로그램 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("");
				break;
			}
		}
	}

//	등록
	public void register() {
		while (run) {

			System.out.println("등록 시작");
			System.out.println("이름 >>");
			name = scn.nextLine().trim();
			char[] cha = name.toCharArray();
			for (char c : cha) {
				if (c > 55203 || c < 44032) {
					System.err.println("이름에 한글만 입력하세요.");
				} else {
					break;
				}
			}
		}
		while (true) {
			try {
				System.out.println("키 >>");
				height = Double.parseDouble(scn.nextLine());
				System.out.println("몸무게 >>");
				weight = Double.parseDouble(scn.nextLine());
				System.out.println("성적 >>");
				scoure = Integer.parseInt(scn.nextLine());

				break;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.err.println("올바른 값을 입력하세요.");
			}
		}
		students.add(new Student(name, height, weight, scoure));
		System.out.println("입력 완료");
	}

//	수정
	public void editStu() {
		System.out.println("수정시작");
		System.out.println("이름 >>");
		name = scn.nextLine();

	}

//	삭제
	public void removeStu() {
		System.out.println("삭제 시작");
		System.out.println("이름 >>");
		name = scn.nextLine();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(name)) {
				students.remove(i);
				System.out.println("삭제완료");
				return;
			}
		}
	}

//	조회
	public void search() {
		// 이름 점수
//		-------------------
//		길동       90
		System.out.println("이름     점수");
		System.out.println("------------");
		for (Student stu : students) {
			System.out.printf("%s     %d \n", stu.getName(), stu.getScoure());
		}
	}

//	종료하기
	public void save() {
		// C:/temp/studentList.txt
		try {
			Writer wr = new FileWriter("C:/temp/studentList.txt");
//			BufferedWriter br = new BufferedWriter(wr);
			for (Student stu : students) {
				wr.write(stu.getName() + " " + stu.getHdight() + " " + stu.getWeight() + " " + stu.getScoure() + "\n");
			}
			wr.flush();
			wr.close();
			System.out.println("saved");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("err");
			e.printStackTrace();
		}
	}

//	로드
	public void init() {
		try {
			Reader reader = new FileReader("C:/temp/studentList.txt"); // 읽으려는 위치
			BufferedReader br = new BufferedReader(reader); // 문자 기반 입력 스트림에 연결되어 버퍼를 제공해주는 보조 스트림.

			while (true) {
				String str = br.readLine(); // 한 줄씩 읽어서 넘겨주는 메소드.

				if (str == null)
					break;
				String[] strAry = str.split(" "); // 읽어 들인 줄을 공백으로 나눠서 배열에 담는다.
//				System.out.println(str);
				Student stu = new Student(strAry[0], Double.parseDouble(strAry[1]), Double.parseDouble(strAry[2]),
						Integer.parseInt(strAry[3]));
				students.add(stu);

			}
			br.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
