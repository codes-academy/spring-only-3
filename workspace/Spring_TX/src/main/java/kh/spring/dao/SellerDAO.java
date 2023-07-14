package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.SellerDTO;

@Component
public class SellerDAO {

  public int insert(Connection con, SellerDTO dto) throws Exception {
    String sql = "insert into seller values(seller_seq.nextval, ?, ?)";
    try (
      PreparedStatement pstat = con.prepareStatement(sql);
    ) {
      pstat.setString(1, dto.getBid());
      pstat.setString(2, dto.getPid());
      int result = pstat.executeUpdate();
      return result;
    }
  }
}
