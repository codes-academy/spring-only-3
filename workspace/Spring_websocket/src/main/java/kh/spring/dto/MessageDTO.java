package kh.spring.dto;

//@Setter //외부 라이브러리 이름 추가하면 이렇게 가능
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
