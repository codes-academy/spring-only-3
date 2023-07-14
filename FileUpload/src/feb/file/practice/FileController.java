package feb.file.practice;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("*.file")
public class FileController extends HttpServlet {
  private static int fileIdNo = 1;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    UfileDAO dao = new UfileDAO();
    String cmd = request.getRequestURI().substring(request.getContextPath().length());
    if (cmd.equals("/upload.file")) {
      String rootPath = this.getServletContext().getRealPath("/");
      String filePath = rootPath + "files";

      File uploadPath = new File(filePath);
      if (new File(filePath).exists()) {
        uploadPath.mkdirs();
      }

      DiskFileItemFactory diskFactory = new DiskFileItemFactory();
      diskFactory.setRepository(new File(rootPath + "/WEB-INF/temp"));

      ServletFileUpload sfu = new ServletFileUpload(diskFactory);
      sfu.setSizeMax(10 * 1024 * 1024);

      try {
        List<FileItem> items = sfu.parseRequest(request);
        for (FileItem fi : items) {
          if (fi.getSize() == 0) {
            continue;
          }
          UfileDTO dto = new UfileDTO();
          dto.setOriFileName(fi.getName());
          dto.setFileSize(fi.getSize());
          dto.setFilePath(filePath);

          String tempFileName = null;
          while (true) {
            try {
              long tempTime = System.currentTimeMillis();
              tempFileName = "[" + tempTime + "]" + fi.getName();
              fi.write(new File(filePath + "/" + tempFileName));
              dto.setFileName(tempFileName);
              break;
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
          int result = dao.insert(dto);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (cmd.equals("/list.file")) {
      ArrayList<UfileDTO> lists;
      try {
        lists = dao.select();
        request.setAttribute("lists", lists);
        request.getRequestDispatcher("fileList.jsp").forward(request, response);
      } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("error.jsp");
      }
    } else if (cmd.equals("/download.file")) {
      try {
        int seq = Integer.parseInt(request.getParameter("seq"));
        UfileDTO dto = dao.selectBySeq(seq);

        response.reset();
        response.setContentType("application/octet-stream");

        String fileName = new String(dto.getOriFileName().getBytes("UTF8"), "ISO-8859-1");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        response.setHeader("Content-Length", String.valueOf(dto.getFileSize()));

        File target = new File(dto.getFilePath() + "/" + dto.getFileName());
        byte[] fileContents = new byte[(int) target.length()];

        try (
          DataInputStream fromFile = new DataInputStream(new FileInputStream(target));
          DataOutputStream toClient = new DataOutputStream(response.getOutputStream());
        ) {
          fromFile.readFully(fileContents);
          toClient.write(fileContents);
          toClient.flush();
        } catch (Exception e) {
          e.printStackTrace();
          response.sendRedirect("error.jsp");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else if (cmd.equals("/profile.file")) {
      PrintWriter out = response.getWriter();
      String rootPath = this.getServletContext().getRealPath("/");
      String filePath = rootPath + "resources";

      File uploadPath = new File(filePath);
      if (new File(filePath).exists()) {
        uploadPath.mkdirs();
      } else {
        uploadPath.mkdirs();
      }

      DiskFileItemFactory diskFactory = new DiskFileItemFactory();
      diskFactory.setRepository(new File(rootPath + "/WEB-INF/temp"));

      ServletFileUpload sfu = new ServletFileUpload(diskFactory);
      sfu.setSizeMax(10 * 1024 * 1024);

      try {
        List<FileItem> items = sfu.parseRequest(request);
        for (FileItem fi : items) {
          if (fi.getSize() == 0) {
            continue;
          }
          String tempFileName = null;
          File f = null;
          while (true) {
            try {
              long tempTime = System.currentTimeMillis();
              tempFileName = tempTime + fi.getName();
              f = new File(filePath + "/" + tempFileName);
              fi.write(f);
              break;
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
//				HttpSession session = request.getSession();	
//				session.setAttribute("img", "resources/" + tempFileName);
//				request.setAttribute("img", "resources/" + tempFileName);
          System.out.println(f);
          System.out.println(tempFileName);
//				System.out.println(session.getAttribute("img"));
//				out.print("<script>location.href='image.jsp';</script>");
          out.print("<body><img src='resources/" + tempFileName + "'></body>");
//				request.getRequestDispatcher("image.jsp").forward(request, response);
        }
      } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("error.jsp");
      }
    }

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}