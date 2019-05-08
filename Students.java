package Student_management;

public class Students {
	private String name;
	private int result;
	private int ranking;
	
	Students(String name, int result) {
		this.name = name;
		this.result = result;
	}
	public String print_name(){
		return name;
	}
	public int print_result() {
		return result;
	}
	public int print_ranking() {
		return ranking;
	}
	public void set_ranking(int ranking) {
		this.ranking = ranking;
	}
}
