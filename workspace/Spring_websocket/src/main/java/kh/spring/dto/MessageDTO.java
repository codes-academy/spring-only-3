package kh.spring.dto;

//@Setter //�ܺ� ���̺귯�� �̸� �߰��ϸ� �̷��� ����
//@Getter //lombok
//@NoArgConstructor
public class MessageDTO {
  private String name;
  private String message;

  public MessageDTO(String name, String message) {
    super();
    this.name = name;
    this.message = message;
  }

  public MessageDTO() {
    super();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
