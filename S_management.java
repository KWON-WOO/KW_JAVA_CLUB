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
			System.out.println("1. 학생추가");
			System.out.println("2. 석차검색");
			System.out.println("3. 성적출력");
			System.out.println("4. 파일 불러오기");
			System.out.println("5. 입력한 데이터 저장 후 종료");
			System.out.println("6. 종료");
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
			default: System.out.println("잘못된 입력값");
			System.out.println();
				break;
			}
			if (1 == EXIT) break;
		}
	}
	void Sadd(){
		System.out.print("추가 할 학생 이름 > ");
		String name = scan.next();
		System.out.print("학생 성적 > ");
		int result = scan.nextInt();
		scan.nextLine();
		student.add(new Students(name,result));
		System.out.println();
	}
	
	void Srank() {
		int rank;
		int pass = 0;
		int inx = 0;
		System.out.print("석차 확인하고픈 학생 이름을 입력해오 > ");
		String select = scan.next();
		for (int a = 0; a < student.size(); a++) {
			if (select.equals(student.get(a).print_name())) {
				pass = 1;
				inx = a;
				break;
			}
		}
		if (pass == 0) System.out.println("해당 학생 못찾았어오");
		else {
			for(int i = 0; i < student.size();i++) {
				rank = 1;
				for (int j = 0; j < student.size(); j++) {
					if (student.get(i).print_result() < student.get(j).print_result()) rank++;
				}
				System.out.println(rank);
				student.get(i).set_ranking(rank);
			}
			System.out.printf("이름\t|석차\n");
			for (int k = 0; k < student.size(); k++) {
				System.out.printf("%s\t|%d등\n",student.get(k).print_name(),student.get(k).print_ranking());	
			}
			System.out.println("해당 학생은 " + student.get(inx).print_ranking() + "등입니다");
			System.out.println();
		}
	}
	void print_result() {
		int inx = 0;
		int pass = 0;
		System.out.print("점수 확인하고픈 학생 이름을 입력해오 > ");
		String select = scan.next();
		for (int a = 0; a < student.size(); a++) {
			if (select.equals(student.get(a).print_name())) {
				pass = 1;
				inx = a;
				break;
			}
		}
		if (pass == 0) System.out.println("해당 학생을 못찾았어오");
		else {
			System.out.printf("이름\t|점수\n");
			for (int k = 0; k < student.size(); k++) {
				System.out.printf("%s\t|%d점\n",student.get(k).print_name(),student.get(k).print_result());	
			}
			System.out.println("해당 학생은 " + student.get(inx).print_result() + "점입니다");
			System.out.println();
		}
	}
}
//성적입력, 석차검색, 성적 출력
