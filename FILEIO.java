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
			System.out.println("�ҷ��� ������ ��θ� �Է����ּſ�(Ȯ���� ����)");
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
			System.out.println("�Է��� ������ �������� ����");
		} catch(NoSuchElementException e) {
			e.getStackTrace();
		}
		System.out.println("�ҷ���");
	}
	public void File_save(ArrayList<Students> data) {
		try {
			if (data.size() == 0) {System.out.println("������ �����Ͱ� ���� �� ������");}
			else {
			System.out.println("������ ��ο� ���ϸ� �Է����ּſ�(Ȯ��������)");
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
			System.out.println("���� �Ϸ�");
			save.close();
		}} catch(Exception e) {
			e.getStackTrace();
		}
	}
}
