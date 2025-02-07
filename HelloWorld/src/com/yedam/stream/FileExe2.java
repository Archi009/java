package com.yedam.stream;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileExe2 {
	public static void main(String[] args) {
		// 보조 스트림(입출력 스트림.)

		try {
			Reader reader = new FileReader("C:/temp/student.txt"); //읽으려는 위치
			BufferedReader br = new BufferedReader(reader);        //문자 기반 입력 스트림에 연결되어 버퍼를 제공해주는 보조 스트림.
			
			while (true) {
				String str = br.readLine();							// 한 줄씩 읽어서 넘겨주는 메소드.
				if(str == null) break;
				String[] strAry = str.split(" ");					// 읽어 들인 줄을 공백으로 나눠서 배열에 담는다.
//				System.out.println(str);
							
				System.out.println("이름: "+strAry[0]+", 영어: "+strAry[1]+", 수학: "+strAry[2]);
			}
			br.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
