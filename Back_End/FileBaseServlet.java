
import java.io.IOException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.*;
public class FileBaseServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) {  
	
	response.setContentType("application/javascript");
	 PrintWriter out = response.getWriter();
	 
	    String key = request.getParameter("key");
		File dir = request.getParameter("dir");
        JSONobject obj = new JSONobject(request.getParameter("data"));
		
		// to call the doSave method which is defined in the FileStore class
	    String status = FileStore.doSave(key,dir,data);
	    out.println(status);
	}
    
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/javascript");
	     PrintWriter out = response.getWriter();
	 
	    String key = request.getParameter("key");
		File dir = request.getParameter("dir");
        JSONobject data = new JSONobject(request.getParameter("data"));
		
		// to call the doRead method which is defined in the FileStore class
		String message  = FileStore.doRead(dir,key);
		 out.println(message);
	     
	}

 
    }
   
}