package kh.spring.dto;

import org.springframework.web.multipart.MultipartFile;

public class DTO {
  private String name;
  private MultipartFile image;

  public DTO() {
    super();
  }

  public DTO(String name, MultipartFile image) {
    this.name = name;
    this.image = image;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MultipartFile getImage() {
    return image;
  }

  public void setImage(MultipartFile image) {
    this.image = image;
  }

}
