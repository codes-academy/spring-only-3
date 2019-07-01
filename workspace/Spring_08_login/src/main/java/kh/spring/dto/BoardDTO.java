package kh.spring.dto;

import java.sql.Date;

public class BoardDTO {
		private int seq;
		private String title;
		private String contents;
		private String writer;
		private Date writedate;
		private int viewcount;
		private String ipaddr;
		private String snail;
		public BoardDTO(int seq, String title, String contents, String writer, Date writedate, int viewcount,
				String ipaddr, String snail) {
			super();
			this.seq = seq;
			this.title = title;
			this.contents = contents;
			this.writer = writer;
			this.writedate = writedate;
			this.viewcount = viewcount;
			this.ipaddr = ipaddr;
			this.snail = snail;
		}
		public BoardDTO() {
			super();
		}
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq = seq;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContents() {
			return contents;
		}
		public void setContents(String contents) {
			this.contents = contents;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public Date getWritedate() {
			return writedate;
		}
		public void setWritedate(Date writedate) {
			this.writedate = writedate;
		}
		public int getViewcount() {
			return viewcount;
		}
		public void setViewcount(int viewcount) {
			this.viewcount = viewcount;
		}
		public String getIpaddr() {
			return ipaddr;
		}
		public void setIpaddr(String ipaddr) {
			this.ipaddr = ipaddr;
		}
		public String getSnail() {
			return snail;
		}
		public void setSnail(String snail) {
			this.snail = snail;
		}
		
	}
