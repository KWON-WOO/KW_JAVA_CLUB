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
			System.out.println("�ҷ��� ������ ��θ� �Է����ּſ�(Ȯ���� ����)");
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
			System.out.println("�Է��� ������ �������� ����");
		}
	}
	public void File_save(ArrayList<Students> data) {
		try {
			if (data.size() == 0) {System.out.println("������ �����Ͱ� ���� �� ������");}
			else {
			System.out.println("������ ��ο� ���ϸ� �Է����ּſ�(Ȯ��������)");
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
			System.out.println("���� �Ϸ�");
			save.close();
		}} catch(Exception e) {
			e.getStackTrace();
		}
	}
}
