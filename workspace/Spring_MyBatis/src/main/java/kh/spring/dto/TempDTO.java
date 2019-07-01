package kh.spring.dto;

public class TempDTO {
	private int num;
	private String id;
	private String contents;
	public TempDTO(int num, String id, String contents) {
		super();
		this.num = num;
		this.id = id;
		this.contents = contents;
	}
	public TempDTO() {
		super();
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
