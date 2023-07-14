package kh.spring.dto;

public class PayDTO {
  private int seq;
  private String pid;
  private String pname;

  public PayDTO(int seq, String pid, String pname) {
    super();
    this.seq = seq;
    this.pid = pid;
    this.pname = pname;
  }

  public PayDTO() {
    super();
  }

  public int getSeq() {
    return seq;
  }

  public void setSeq(int seq) {
    this.seq = seq;
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }

}
