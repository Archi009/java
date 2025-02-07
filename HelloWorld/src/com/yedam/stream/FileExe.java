package com.yedam.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileExe {
	public static void main(String[] args) {
		long startTime = System.nanoTime();

//		ListExe.java읽기
		try {
			Reader reader = new FileReader("c:temp/ListExe.java");
			while(true) {
				int chr = reader.read(); //char(2byte)
				
				System.out.print((char) chr); // 65 -> A
				if(chr ==-1) break;
			}
			
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		long endTime = System.nanoTime();
		long min = (endTime - startTime) / (1000000000L * 60);
		double sec = (endTime - (double) (startTime)) / (1000000000L);
		System.out.println(min + "분  " + sec + "초");

		System.out.println("end of greg");

	}
	void write(){
		//문자기반 파일 출력.
				try {
					Writer wr = new FileWriter("C:/temp/test2.txt");
					wr.write(65);
					wr.write(new char[] {'B', 'C'});
					wr.write("DEF");
					wr.write("GHIJKLMN",2,3);
					
					
					wr.flush();
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
//	byte기반 파일 복사
	void copy() {
		// C:/temp/sample.jpg -> C:/temp/copy.jpg 생성
				try {
					InputStream is = new FileInputStream("C:/temp/sample.jpg");
					OutputStream os = new FileOutputStream("C:/temp/copy.jpg");

					int data = -1;
					byte[] buf = new byte[100]; // 100개의 byte
					while (true) {
						// 읽기
						data = is.read(buf);// 1byte//// buf(100개의 byte)단위씩 읽어 들인다
						os.write(buf); // 읽은 파일을 copy파일에 쓴다 //1mb 니까 100만 byte 반복 할 것이다

						if (data == -1) {
							break;
						}
					}
					is.close();
					os.flush();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	//byte기반 파일 읽기.
	void input() {
		try {
			InputStream is = new FileInputStream("C:/temp/test1.dat");
			while (true) {

				int data = is.read(); // 바이트 읽고 반환해주는데, 더 이상 읽은 값이 없을때 -1 반환.
				System.out.println(data);
				if (data == -1)
					break;
			}
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//byte기반 파일 쓰기.
	void output() {
//		출력스트림(바이트 기반) OutPutStream.
		try {
			OutputStream os = new FileOutputStream("C:/temp/test1.dat");
			os.write(10);
			os.write(20);
			os.write(30);
			os.flush();
			os.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
