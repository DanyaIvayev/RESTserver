package example;
/*import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;*/
import java.io.IOException;

/*import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;*/
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Danis on 05.11.2015.
 */
// The Java class will be hosted at the URI path "/helloworld"

public class HelloWorld {
    // The Java method will process HTTP GET requests
   /* @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }*/
    @SuppressWarnings("serial")
    public static class HelloServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Hello SimpleServlet</h1>");
        }

    }
    public static void main(String[] args) throws IOException {
       /* HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        server.start();

        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/helloworld");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
*/      Server server =null;
        try {
            server = new Server(8080);
            ServletHandler handler = new ServletHandler();
            //handler.addServlet(new ServletHolder(new HelloServlet()));
            ServletHolder holder = handler.addServletWithMapping(HelloServlet.class, "/hello");//Set the servlet to run.
            server.setHandler(handler);
            server.start();
            server.join();
        } catch(java.lang.Exception e){
            try {
                if (server != null)
                    server.stop();
            } catch (Exception e1){
                e.printStackTrace();
            }
        }
    }

}
