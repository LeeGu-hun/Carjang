package member;

public class Car {
	private String num, id, kind;

	public Car(String num, String id, String kind) {
		super();
		this.num = num;
		this.id = id;
		this.kind = kind;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
}