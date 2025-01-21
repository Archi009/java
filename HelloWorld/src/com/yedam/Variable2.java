package com.yedam;

public class Variable2 {
	public static void main(String[] args) {
		int num = 5;
		for (int i = 1; i <= 9; i++) {
           for(int j = 2; j <= 9; j++ ) {
//        	   System.out.print(i+"X"+j+"="+(i * j)+"\n");
//        	   System.out.printf("%1$d * %3$d = %2$d\n", j, i, j * i);  // `${num}` 같이 printf 를 쓰면 출력 구문을 설정할 수 있다. %d는 정수형 %s는 문자형 (n$)를 통해 순서 변경도 가능
//        	   System.out.print(j+" X "+i+" = "+(i * j)+"\t");
        	   System.out.printf("%d * %d = %2d   ", i, j, j * i); //%와 파라메터 중간에 정수를 넣으면 그만큼의 칸을 차지하겠다라는 뜻
        	   
           }
           System.out.print("\n");
		}
		System.out.println("end of prog");

	}
}
