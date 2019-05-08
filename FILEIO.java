package Student_management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FILEIO {
	static Scanner scan = new Scanner(System.in);
	FILEIO(){}
	public void File_open() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("불러올 파일의 경로를 입력해주셔요(확장자 포함)");
			System.out.print(" > ");
			File file = new File(scan.nextLine());
			FileReader reader = new FileReader(file);
			int count = 0;
			while(true) {
				if((count = reader.read()) == -1) break;
				System.out.print((char)count);
			}
			System.out.println();
			reader.close();
		} catch(FileNotFoundException e) {
		} catch(IOException e) {
			System.out.println(e);
			System.out.println("입력한 파일이 존재하지 않음");
		}
	}
	public void File_save(ArrayList<Students> data) {
		try {
			if (data.size() == 0) {System.out.println("저장할 데이터가 없음 걍 종료함");}
			else {
			System.out.println("저장할 경로와 파일명를 입력해주셔요(확장자포함)");
			System.out.print(" > ");
			OutputStream save = new FileOutputStream(scan.nextLine());
			byte [] name;
			for (int i = 0; i< data.size(); i++) { 
				name = data.get(i).print_name().getBytes();
				save.write(name);
				save.write((byte)',');
				name = null;
				name = Integer.toString(data.get(i).print_result()).getBytes();
				save.write(name);
				save.write((byte)'\n');
				name = null;
			}
			System.out.println("저장 완료");
			save.close();
		}} catch(Exception e) {
			e.getStackTrace();
		}
	}
}
