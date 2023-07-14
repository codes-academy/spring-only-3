package kh.spring.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;

@Repository
public class BoardDAO {

  @Autowired
  private JdbcTemplate template;
  @Autowired
  HttpSession session;
  @Autowired
  HttpServletRequest request;

  public int insertBoard(BoardDTO dto) {
    String sql = "insert into board values(b_seq.nextval, ?, ?, ?, default, ?, ?, default)";
    return template.update(sql, dto.getTitle(), dto.getContents(), session.getAttribute("id"), 0, request.getRemoteAddr());
  }

  public List<BoardDTO> boardList() {
    String sql = "select * from board";
    return template.query(sql, new RowMapper<BoardDTO>() {
      @Override
      public BoardDTO mapRow(ResultSet rs, int rn) throws SQLException {
        BoardDTO dto = new BoardDTO();
        dto.setSeq(rs.getInt("seq"));
        dto.setTitle(rs.getString("title"));
        dto.setContents(rs.getString("contents"));
        dto.setWriter(rs.getString("writer"));
        dto.setWritedate(rs.getDate("writedate"));
        dto.setViewcount(rs.getInt("viewcount"));
        dto.setIpaddr(rs.getString("ipaddr"));
        return dto;
      }
    });
  }

  public BoardDTO clickTitle(int seq) {
    String sql = "select * from board where seq=?";
    return template.queryForObject(sql, new Object[]{seq}, new RowMapper<BoardDTO>() {
      @Override
      public BoardDTO mapRow(ResultSet rs, int rn) throws SQLException {
        BoardDTO dto = new BoardDTO();
        dto.setSeq(rs.getInt("seq"));
        dto.setTitle(rs.getString("title"));
        dto.setContents(rs.getString("contents"));
        dto.setWriter(rs.getString("writer"));
        dto.setWritedate(rs.getDate("writedate"));
        dto.setViewcount(rs.getInt("viewcount"));
        dto.setIpaddr(rs.getString("ipaddr"));
        return dto;
      }
    });
  }

  public String getNavi(int currentPage) {
    String sql = "select count(*) from board";
    int recordTotalCount = template.queryForObject(sql, Integer.class);
    int recordCountPerPage = 10;
    int naviCountPerPage = 10;

    int pageTotalCount = 0;
    if (recordTotalCount % recordCountPerPage > 0) {
      pageTotalCount = recordTotalCount / recordCountPerPage + 1;
    } else {
      pageTotalCount = recordTotalCount / recordCountPerPage;
    }

    if (currentPage < 1) {
      currentPage = 1;
    } else if (currentPage > pageTotalCount) {
      currentPage = pageTotalCount;
    }

    int startNavi;
    int endNavi;

    startNavi = (currentPage - 1) / naviCountPerPage * naviCountPerPage + 1;
    endNavi = startNavi + (naviCountPerPage - 1);

    if (endNavi > pageTotalCount) {
      endNavi = pageTotalCount;
    }

    boolean needPrev = true;
    boolean needNext = true;

    if (startNavi == 1) {
      needPrev = false;
    }
    if (endNavi == pageTotalCount) {
      needNext = false;
    }
    System.out.println(startNavi + ":" + pageTotalCount);
    StringBuilder sb = new StringBuilder();
    if (needPrev) {
      sb.append("<span><a href='/paging?currentPage=" + (startNavi - 1) + "'>" + "before" + "</a></span>");
    }
    for (int i = startNavi; i <= endNavi; i++) {
      sb.append("<button type='button' class='btn btn-outline-light myBtn m-1'><a href='paging?currentPage=" + i + "'>" + i + " </a></button>");
    }
    if (needNext) {
      sb.append("<span><a href='/paging?currentPage=" + (endNavi + 1) + "'>" + "after" + "</a></span>");
    }
    return sb.toString();
  }

  public List<BoardDTO> selectByPage(int start, int end) {
    String sql = "select * from\r\n" +
      "    (select \r\n" +
      "        row_number() over(order by seq desc) as rown,\r\n" +
      "         board.*\r\n" +
      "    from board)\r\n" +
      "where rown between " + start + " and " + end;
    return template.query(sql, new RowMapper<BoardDTO>() {
      @Override
      public BoardDTO mapRow(ResultSet rs, int rn) throws SQLException {
        int seq = rs.getInt("seq");
        String title = rs.getString("title");
        String contents = rs.getString("contents");
        String writer = rs.getString("writer");
        Date writedate = rs.getDate("writedate");
        int viewcount = rs.getInt("viewcount");
        String ipaddr = rs.getString("ipaddr");
        BoardDTO dto = new BoardDTO(seq, title, contents, writer, writedate, viewcount, ipaddr, null);
        return dto;
      }
    });
  }

}
