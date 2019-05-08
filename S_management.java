package Student_management;

import java.util.ArrayList;
import java.util.Scanner;

public class S_management {
	static Scanner scan = new Scanner(System.in);
	
	ArrayList<Students> student;
	int select;
	int EXIT;
	S_management(){
		student = new ArrayList<Students>();
		select = 0;
		EXIT = 0;
		menu();
	}
	void menu(){
		FILEIO fileio = new FILEIO();
		while(true) {
			System.out.println("1. �л��߰�");
			System.out.println("2. �����˻�");
			System.out.println("3. �������");
			System.out.println("4. ���� �ҷ�����");
			System.out.println("5. �Է��� ������ ���� �� ����");
			System.out.println("6. ����");
			System.out.print("> ");
			select = scan.nextInt();
			System.out.println();
			switch (select) {
			case 1:Sadd();
				break;
			case 2: Srank();
				break;
			case 3: print_result();
				break;
			case 4: fileio.File_open();
				break;
			case 5: fileio.File_save(student);
			case 6:	EXIT = 1;
				break;
			default: System.out.println("�߸��� �Է°�");
			System.out.println();
				break;
			}
			if (1 == EXIT) break;
		}
	}
	void Sadd(){
		System.out.print("�߰� �� �л� �̸� > ");
		String name = scan.next();
		System.out.print("�л� ���� > ");
		int result = scan.nextInt();
		scan.nextLine();
		student.add(new Students(name,result));
		System.out.println();
	}
	
	void Srank() {
		int rank;
		int pass = 0;
		int inx = 0;
		System.out.print("���� Ȯ���ϰ��� �л� �̸��� �Է��ؿ� > ");
		String select = scan.next();
		for (int a = 0; a < student.size(); a++) {
			if (select.equals(student.get(a).print_name())) {
				pass = 1;
				inx = a;
				break;
			}
		}
		if (pass == 0) System.out.println("�ش� �л� ��ã�Ҿ��");
		else {
			for(int i = 0; i < student.size();i++) {
				rank = 1;
				for (int j = 0; j < student.size(); j++) {
					if (student.get(i).print_result() < student.get(j).print_result()) rank++;
				}
				System.out.println(rank);
				student.get(i).set_ranking(rank);
			}
			System.out.printf("�̸�\t|����\n");
			for (int k = 0; k < student.size(); k++) {
				System.out.printf("%s\t|%d��\n",student.get(k).print_name(),student.get(k).print_ranking());	
			}
			System.out.println("�ش� �л��� " + student.get(inx).print_ranking() + "���Դϴ�");
			System.out.println();
		}
	}
	void print_result() {
		int inx = 0;
		int pass = 0;
		System.out.print("���� Ȯ���ϰ��� �л� �̸��� �Է��ؿ� > ");
		String select = scan.next();
		for (int a = 0; a < student.size(); a++) {
			if (select.equals(student.get(a).print_name())) {
				pass = 1;
				inx = a;
				break;
			}
		}
		if (pass == 0) System.out.println("�ش� �л��� ��ã�Ҿ��");
		else {
			System.out.printf("�̸�\t|����\n");
			for (int k = 0; k < student.size(); k++) {
				System.out.printf("%s\t|%d��\n",student.get(k).print_name(),student.get(k).print_result());	
			}
			System.out.println("�ش� �л��� " + student.get(inx).print_result() + "���Դϴ�");
			System.out.println();
		}
	}
}
//�����Է�, �����˻�, ���� ���
