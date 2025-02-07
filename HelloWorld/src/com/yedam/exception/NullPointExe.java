package com.yedam.exception;



import com.yedam.reference.Student;

public class NullPointExe {
	public static void main(String[] args) {

		Student student = null;
		String result = null;
		String[] strAry = { "Hello", "World" };
		try {
			int menu = Integer.parseInt("a"); //String을 int로 바꾸려고 할 때 RuntimeException의 하위 NumberFormatException이 발생한다. 
			strAry[2] = "Nice"; // 배열의 정해진 범위 바깥에 값을 넣으려고 한다
			System.out.println(student.getStudentNm());// 구문상 오류는 없지만, null의 존재로 인해 오류 발생 -> 프로그램이 중단 된다.
//		} catch (NullPointerException e) {
//			System.err.println(e);
//			result = "예외가 발생 했을때 try/catch 구문으로 예외처리 -> 프로그램 종료를 막고 진행 할 수 있게한다.";
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.err.println(e);
//			result = "배열의 범위를 초과한 오류";
//		}
//		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) { // |로 나눠서 두가지 타입중 어떤 타입이 매개변수로 들어오건 구문 안에서 e라는 변수로 통일 돼서 사용된다!!
//			System.out.println("null값을 참조 또는 배열 범위 초과.");
//			e.printStackTrace();// 오류의 정확한 경위를 알려줌
//		}
		}catch (RuntimeException e){
			System.out.println("상위 exception은 하위 exception을 처리 할 수 있다"); //부모 변수에 상속 받은 자식 값을 집어 넣을 수 있듯이 //매개변수를 부모로 지정하고 자식 값을 넣으면 처리 가능한가?
			e.printStackTrace();
		}catch (Exception e) {
			System.err.println("RuntimeException을 포함한 다른 알 수 없는 exception들을 모두 처리 할 수있다.");
		}
		
		//=> try/catch 구문이 많을 수록 프로그램의 성능에 영향을 주기 때문에 최대한 적게 쓰자 {범위도 적을 수록 좋다 (ex. Exception > RuntimeException > etc.. } 
		System.out.println(result);

	}
}
