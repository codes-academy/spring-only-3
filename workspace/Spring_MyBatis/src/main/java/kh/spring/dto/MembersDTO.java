package kh.spring.dto;

public class MembersDTO {
  private int seq;
  private String id;
  private String pw;
  private String name;
  private String tel;

  public MembersDTO(int seq, String id, String pw, String name, String tel) {
    super();
    this.seq = seq;
    this.id = id;
    this.pw = pw;
    this.name = name;
    this.tel = tel;
  }

  public MembersDTO() {
    super();
  }

  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

}
