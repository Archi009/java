package com.yedam.api;



public class TimeExe {
	public static void main(String[] args) {
		// ?분?초 출력.
		// 1부터 1억 까지 짝수합을 구하는 시간.
		long sum = 0;
		long startTime = System.nanoTime();
		
		for (long i = 1; i <= 10000000000L; i++) {
			if (i % 250 == 0) {
				sum += i;
				
			}

		}
		long endTime = System.nanoTime();
		long min = (endTime - startTime) /(1000000000L * 60); 
		long sec = (endTime - startTime) /(1000000000L); 
		System.out.printf("합: %d  걸린 시간 :  %d 분 %d 초 ", sum , min, sec);
		
	}
	
}
