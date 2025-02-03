package com.yedam.reference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 실행 클래스
 * 1.글목록 2.글등록 3.글 삭제 9.종료
 * 
 * */
public class BoardExe {

	static Board[] boardRepo = new Board[100]; // 게시글등록 배열
	static Scanner scn = new Scanner(System.in);
	static String loginId;// 로그인 정보 저장
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void initData() throws ParseException {
		// 배열의 샘플 데이터
		boardRepo[0] = new Board("게시글 제목1", "내용입니다", "user01", sdf.parse("2020-01-25"));
		boardRepo[1] = new Board("게시글 제목2", "내용입니다2", "user02", sdf.parse("2020-02-25"));
		boardRepo[2] = new Board("게시글 제목3", "내용입니다3", "user03", sdf.parse("2020-03-25"));
		boardRepo[3] = new Board("게시글 제목4", "내용입니다4", "user04", sdf.parse("2020-04-25"));
		boardRepo[4] = new Board("게시글 제목5", "내용입니다4", "user04", sdf.parse("2020-05-25"));
		boardRepo[5] = new Board("게시글 제목6", "내용입니다4", "user04", sdf.parse("2020-06-25"));
		boardRepo[6] = new Board("게시글 제목7", "내용입니다4", "user04", sdf.parse("2020-07-25"));
		boardRepo[7] = new Board("게시글 제목8", "내용입니다4", "user04", sdf.parse("2020-08-25"));
		boardRepo[8] = new Board("게시글 제목9", "내용입니다4", "user04", sdf.parse("2020-09-25"));
		boardRepo[9] = new Board("게시글 제목10", "내용입니다4", "user04", sdf.parse("2020-10-25"));
		boardRepo[10] = new Board("게시글 제목11", "내용입니다4", "user04", sdf.parse("2020-11-25"));
		boardRepo[11] = new Board("게시글 제목12", "내용입니다4", "user04", sdf.parse("2020-12-25"));

	}

	public static void boardList() {
		// 글목록.
		// 1페이지: 0~4 , 2페이지: 5~9 , 3페이지 10~14

		int lastPage = (int) (Math.ceil(getMaxCnt() / 5.0));

		int page = 1;
		while (true) { // 5개씩 나오는 페이지 1페이지 부터 출력
			// 삭제시 null이 된부분을 건너띄고 출력해버리는 바람에 페이지의 출력물 개수가 달라졌다.
			// 배열에서 삭제된곳의 null값을 업애고 배열을 당겨담아주는 방식을 진행했다.
//			int count = 0;
//			for (int i = 0; i < boardRepo.length; i++) {
//				if (boardRepo[i] != null) {
//					boardRepo[i - count] = boardRepo[i];
//				} else {
//					count++;
//				}
//			}
//			int firstIndex = (page - 1) * 5;
//			int lastIndex = (page * 5) - 1;
//			for (int i = firstIndex; i <= lastIndex; i++) {
//				if (boardRepo[i] != null) {
//					System.out.println(boardRepo[i].showBoard());
//				}
//			}

//			1page: 1~5, 2page: 6~10, 3page: 11~15
			int endCnt = page * 5;
			int startCnt = endCnt - 5;
			int loopCnt = 0;
			for (int i = 0; i < boardRepo.length; i++) {
				if (boardRepo[i] != null) {
					loopCnt++;
					if (loopCnt > startCnt && loopCnt <= endCnt) {
						System.out.println(loopCnt + "  " + boardRepo[i].showBoard());
					}
				}
			}

			System.out.println("이전페이지:p , 이후페이지:n, 종료:q");
			String paging = scn.nextLine(); // 페이지 이동

			if (paging.equals("n")) {
				if (page < lastPage) { // &&문으로도 가능하지만, 그렇게 하면 추가적인 조건을 붙일때 복잡해 질 수 있다.
					page++;
				}
			} else if (paging.equals("p")) {
				if (page > 1) {
					page--;
				}

			} else if (paging.equals("q")) {
				return;
			}
		} // end of while

	}// end of boardList()
		// 배열을 매개값으로 전달하면 건수가 몇건인가 반환.

	public static int getMaxCnt() {
		int count = 0;
		for (int i = 0; i < boardRepo.length; i++) {
			if (boardRepo[i] != null) {
				count++;
			}
		}
		return count;
	}

	public static void addBoard() {
		// 글등록.
//		제목 : 5글자 이상 15글자 이하. 콘솔 출력("등록불가합니다");
//		동일한 제목 있을시 콘솔 출력("이미 있는 제목입니다");
		System.out.println("제목을 입력 >>");
		String title = scn.nextLine();
		
//		유효성 검사
//		제목길이
		if (title.length() >= 5 && title.length() <= 15) {
//			
			for (int i = 0; i < boardRepo.length; i++) {
				if (boardRepo[i] == null) {
					for (int j = 0; j < boardRepo.length; j++) {
						
						if (boardRepo[j].getTitle().equals(title)) {
							System.out.println("이미 있는 제목입니다.");
							return;
						}else if(boardRepo[j] != null){
							System.out.println("내용을 입력 >>");
							String content = scn.nextLine();
							boardRepo[j] = new Board(title, content, loginId, new Date());
							System.out.println("등록완료");
							break;
						}
					}
				}
			}
		} else {
			System.out.println("등록불가합니다.");
			return;
		}

//		Date writeDate = new Date();

	}

	public static void removeBoard() {
		// 글삭제.
		System.out.println("삭제할 제목 입력");
		String title = scn.nextLine();

		for (int i = 0; i < boardRepo.length; i++) {
			String input = boardRepo[i].getTitle();
			if (title.equals(input)) {
				boardRepo[i] = null;
				break;
			}

		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////main
///////////////////////////////////////////////
	public static void main(String[] args) {
		// 메인 메소드 실행 후 게시판 목록 실행 전 로그인 과정.
//		MemberExe exe = new MemberExe();

		while (true) {

			// id, password 일치하면 게시판 기능 사용가능.
			System.out.print("아이디를 입력>>");
			String id = scn.nextLine();
			System.out.print("비밀번호를 입력>>");
			String pw = scn.nextLine();
			String nm = MemberExe.login(id, pw);

			if (nm != null) {
				System.out.printf("%s 님 반값습니다. \n", nm);
				loginId = id;
				break;
			} else {
				System.out.println("아이디 또는 비밀번호를 확인 하세요.");
			}
		} // end of while 로그인 종료

		boolean run = true;
		try {
			initData();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 더미데이터

		while (run) {
			System.out.println("1.글목록 2.글등록 3.글 삭제 9.종료");
			System.out.println("선택 >>");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 목록
				boardList();
				break;
			case 2: // 등록
				addBoard();
				break;
			case 3: // 삭제
				removeBoard();
				break;
			case 9: // 종료

				break;

			default: // 그 외
				System.out.println("유효한 값을 입력해주세요.");
				break;
			}

		} // end of while
		System.out.println("end of prog.");
	}// end of main
}
