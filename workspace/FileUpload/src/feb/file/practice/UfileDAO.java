package feb.file.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UfileDAO {

	public Connection ready() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "kh";
			String password = "kh";
			Connection con = DriverManager.getConnection(url, user, password);
			return con;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insert(UfileDTO dto) throws Exception{
		String sql = "insert into ufile values(ufile_seq.nextval, ?, ?, ?, ?)";
		try(
				Connection con = this.ready();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, dto.getFileName());
			pstat.setString(2, dto.getOriFileName());
			pstat.setString(3, dto.getFilePath());
			pstat.setLong(4, dto.getFileSize());
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}
	}

	public ArrayList<UfileDTO> select() throws Exception{
		String sql = "select * from ufile";
		try(
				Connection con = this.ready();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
				){
			ArrayList<UfileDTO> lists = new ArrayList(); 
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String fileName = rs.getString("fileName");
				String oriFileName = rs.getString("oriFileName");
				String filePath = rs.getString("filePath");
				long fileSize = rs.getLong("fileSize");
				UfileDTO dto = new UfileDTO(seq, fileName, oriFileName, filePath, fileSize);
				lists.add(dto);
			}
			return lists;
		}
	}

	public UfileDTO selectBySeq(int seq) throws Exception{
		String sql = "select * from ufile where seq = ?";
		try(
				Connection con = this.ready();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setInt(1, seq);
			try(ResultSet rs = pstat.executeQuery()){
				if(rs.next()) {
				int sequence = rs.getInt("seq");
				String fileName = rs.getString("fileName");
				String oriFileName = rs.getString("oriFileName");
				String filePath = rs.getString("filePath");
				long fileSize = rs.getLong("fileSize");
				UfileDTO dto = new UfileDTO(sequence, fileName, oriFileName, filePath, fileSize);
				return dto; 
				}
			return null;
			}
		}
	}

	public UfileDTO selectByFileName(String file) throws Exception{
		String sql = "select * from ufile where fileName = ?";
		try(
				Connection con = this.ready();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, file);
			try(ResultSet rs = pstat.executeQuery()){
				if(rs.next()) {
				int sequence = rs.getInt("seq");
				String fileName = rs.getString("fileName");
				String oriFileName = rs.getString("oriFileName");
				String filePath = rs.getString("filePath");
				long fileSize = rs.getLong("fileSize");
				UfileDTO dto = new UfileDTO(sequence, fileName, oriFileName, filePath, fileSize);
				return dto; 
				}
			return null;
			}
		}
	}
	
	
}
