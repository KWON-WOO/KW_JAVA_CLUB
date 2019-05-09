package Student_management;

import java.io.BufferedReader;
import java.io.File;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class FILEIO {
	Scanner scan = new Scanner(System.in);
	FILEIO(){}
	public void File_open(ArrayList<Students> student) {
		
		try {
			System.out.println("불러올 파일의 경로를 입력해주셔요(확장자 포함)");
			System.out.print(" > ");
			File file = new File(scan.nextLine());
			FileReader reader = new FileReader(file);
			BufferedReader readline = new BufferedReader(reader);
			String line;
			byte [] textline;
			byte count;
			byte inx;
			byte[][] text;
			int result;
			while(true) {
				if((line = readline.readLine()) == null) break;
				text = new byte[2][10];
				textline = line.getBytes();
				count = 0;
				inx = 0;
				for (int i = 0; i < textline.length; i++) {
					if (textline[i] == ',') {
						count++;
						inx = 0;
					} else {
						text[count][inx] = textline[i];
						inx++;
					}
				}
				result = Integer.parseInt(new String(text[1]).trim());
				student.add(new Students(new String(text[0]).trim(), result));	
				text = null;
				textline = null;
			}
			System.out.println();
			reader.close();
		} catch(FileNotFoundException e) {
		} catch(IOException e) {
			System.out.println(e);
			System.out.println("입력한 파일이 존재하지 않음");
		} catch(NoSuchElementException e) {
			e.getStackTrace();
		}
		System.out.println("불러옴");
	}
	public void File_save(ArrayList<Students> data) {
		try {
			if (data.size() == 0) {System.out.println("저장할 데이터가 없음 걍 종료함");}
			else {
			System.out.println("저장할 경로와 파일명를 입력해주셔요(확장자포함)");
			System.out.print(" > ");
			OutputStream save = new FileOutputStream(scan.nextLine());
			for (int i = 0; i< data.size(); i++) { 
				save.write(data.get(i).print_name().getBytes());
				save.write((byte)',');
				save.write(Integer.toString(data.get(i).print_result()).getBytes());
				if (data.get(i).print_ranking() > 0) {
					save.write(Integer.toString(data.get(i).print_ranking()).getBytes());
					save.write((byte)',');
				}
				save.write((byte)'\n');
			}
			System.out.println("저장 완료");
			save.close();
		}} catch(Exception e) {
			e.getStackTrace();
		}
	}
}
