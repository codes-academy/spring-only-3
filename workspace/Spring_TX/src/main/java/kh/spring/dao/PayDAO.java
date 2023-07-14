package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.PayDTO;

@Component
public class PayDAO {

//	public int insert(Connection con, PayDTO dto) throws Exception{
//		String sql = "insert into pay values(pay_seq.nextval, ?, ?)";
//		try(
//			PreparedStatement pstat = con.prepareStatement(sql);
//				){
//			pstat.setString(1, dto.getPid());
//			pstat.setString(2, dto.getPname());
//			int result = pstat.executeUpdate();
//			return result;
//		}
//	}
}
