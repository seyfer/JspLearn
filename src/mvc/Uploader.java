package mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Uploader
 */
@WebServlet("/uploader")
public class Uploader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Uploader() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		if (!ServletFileUpload.isMultipartContent(request)) {
			out.println("Nothing uploaded");
			return;
		}

		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);

		try {
			Map<String, List<FileItem>> items = upload.parseParameterMap(request);
			List<FileItem> fileItems = items.get("file");

			// List<FileItem> items = upload.parseRequest(request);

			for (FileItem item : fileItems) {
				String contentType = item.getContentType();

				// out.println(contentType);

				if (!contentType.equals("image/jpeg") && !contentType.equals("image/png")) {
					out.println("Only png and jpg format image files supported");
					continue;
				}

				String dir = getServletContext().getRealPath("/") + "uploads";
				
//				out.println(dir);
				
				File uploadDir = new File(dir);
				String ext = contentType.equals("image/jpeg") ? ".jpg" : ".png";
				File file = File.createTempFile("img", ext, uploadDir);
				item.write(file);

				out.println("File saved.");
			}

		} catch (FileUploadException e) {
			out.println("Upload failed.");
			return;
		} catch (Exception ex) {
			out.println("Can't save file " + ex.getMessage() + ex.getMessage());
		}
	}

}
