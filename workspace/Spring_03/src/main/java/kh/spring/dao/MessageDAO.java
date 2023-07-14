package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MessageDTO;

@Component
public class MessageDAO {

  @Autowired
  private DataSource ds;

  public int insert(MessageDTO dto) throws Exception {
    String sql = "insert into message values(message_seq.nextval, ?, ?)";
    try (
      Connection con = ds.getConnection();
      PreparedStatement pstat = con.prepareStatement(sql);
    ) {
      pstat.setString(1, dto.getName());
      pstat.setString(2, dto.getMessage());
      int result = pstat.executeUpdate();
      con.commit();
      return result;
    }
  }

  public List<MessageDTO> select() throws Exception {
    String sql = "select * from message";
    try (
      Connection con = ds.getConnection();
      PreparedStatement pstat = con.prepareStatement(sql);
    ) {
      try (ResultSet rs = pstat.executeQuery()) {
        List<MessageDTO> result = new ArrayList(); //스프링에서 new를 하면 안 된다는 게 아니라, new를 안 할 수 있으면 하지 말자는 것. new 해도 됨
        while (rs.next()) {
          MessageDTO dto = new MessageDTO();
          dto.setSeq(rs.getInt("seq"));
          dto.setName(rs.getString("name"));
          dto.setMessage(rs.getString("message"));
          result.add(dto);
        }
        return result;
      }
    }
  }

}
