package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MessageDTO;
import kh.spring.dto.TempDTO;

//@Component //dao�� ���ؼ� ������Ʈ ��� �ٸ� ���� �� �� ����
@Repository //���� Ŭ������ @Service ������̼� ����
public class MessageDAO {
	
	@Autowired
	private SqlSessionTemplate sst;
	
	public int insert() {
		MessageDTO dto = new MessageDTO();
		dto.setName("qqq");
		dto.setMessage("qqq");
		return sst.insert("MessageDAO.insert", dto);
		//(mapper namespace.insert id, dto..)
	}
	
	public int delete() {
		return sst.delete("MessageDAO.delete", 1);
	}
	
	public List<MessageDTO> select(){
		return sst.selectList("MessageDAO.selectList");
	}
	
//	public MessageDTO selectBySeq() {
//		return sst.selectOne("MessageDAO.selectBySeq", 2);
//	}
	public TempDTO selectBySeq() {
		return sst.selectOne("MessageDAO.selectBySeq", 2);
	}
	
	public int update() {
		MessageDTO dto = new MessageDTO();
		dto.setSeq(3);
		dto.setName("jonah");
		dto.setMessage("hello");
		return sst.update("MessageDAO.update", dto);
	}
}
