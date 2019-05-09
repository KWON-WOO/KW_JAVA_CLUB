package Student_management;

import java.util.ArrayList;
import java.util.Scanner;

public class S_management {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Students> student;
	byte select;
	int EXIT;
	S_management(){
		student = new ArrayList<Students>();
		EXIT = 0;
		menu();
	}
	void menu(){
		FILEIO fileio = new FILEIO();
		while(true) {
			System.out.println("1. 학생추가");
			System.out.println("3. 성적 및 석차출력");
			System.out.println("4. 파일 불러오기");
			System.out.println("5. 입력한 데이터 저장 후 종료");
			System.out.println("6. 종료");
			System.out.print("> ");
			select = scan.nextByte();
			scan.nextLine();
			System.out.println();
			switch (select) {
			case 1:Sadd();
				break;
			case 2: Srank();
				break;
			case 3: fileio.File_open(student);
				break;
			case 4: fileio.File_save(student);
			case 5:	EXIT = 1;
				break;
			default: System.out.println("잘못된 입력값");
			System.out.println();
				break;
			}
			if (1 == EXIT) break;
		}
	}
	void Sadd(){
		boolean overlap = false;
		System.out.print("추가 할 학생 이름 > ");
		String name = scan.next();
		for (int i = 0; i < student.size(); i++) {
			if (student.get(i).print_name().equals(name)) {
				System.out.println("중복되는 이름 있음");
				overlap = true;
				break;
			}
		}
		if(false == overlap) {
			System.out.print("학생 성적 > ");
			int result = scan.nextInt();
			scan.nextLine();
			student.add(new Students(name,result));
			System.out.println();
		}
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
			System.out.printf("이름\t|점수\t|석차\n");
			for (int k = 0; k < student.size(); k++) {
				System.out.printf("%s\t|%d점|%d등\n",
						student.get(k).print_name(),student.get(k).print_result(),student.get(k).print_ranking());	
			}
			System.out.println("해당 학생은 " +student.get(inx).print_result()+ "점으로 " + student.get(inx).print_ranking() + "등임");
			System.out.println("이어하려면 아무키나 누르고 엔터치셈");
			scan.next();
		}
	}
}
//성적입력, 석차검색, 성적 출력
