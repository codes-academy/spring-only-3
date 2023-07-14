package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MembersDTO;

@Repository
public class MembersDAO {

  @Autowired
  private SqlSessionTemplate sst;

  public int insert(MembersDTO dto) {
    System.out.println(dto.getId() + dto.getName());
    return sst.insert("MembersDAO.insert", dto);
  }

  public List<MembersDTO> select() {
    return sst.selectList("MembersDAO.selectList");
  }

}
