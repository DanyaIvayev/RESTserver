package example;
/*import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.apache.jasper.servlet.JspServlet;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;

import org.eclipse.jetty.servlet.DefaultServlet;
/*import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;*/

/**
 * Created by Danis on 05.11.2015.
 */
// The Java class will be hosted at the URI path "/helloworld"

public class HelloWorld {
    // The Java method will process HTTP GET requests
    private static final String WEBROOT_INDEX = "/webroot/";
   /* @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }*/
    /*@SuppressWarnings("serial")
    public static class HelloServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter();
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.setHeader("hellopage", "MeetingApp");

            response.getWriter().println("<h1 >Главная страница</h1>\n" +
                    "  <table class=\"insert\">\n" +
                    "    <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"insert\">Фамилия</td>\n" +
                    "      <td><input type=\"text\" id=\"surname\" required placeholder=\"Введите фамилию\" name=\"surname\" size=\"50\"/></td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "      <td class=\"insert\">Имя</td>\n" +
                    "      <td><input type=\"text\" id=\"firstname\" required placeholder=\"Введите Имя\" name=\"firstname\" size=\"50\"/></td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "      <td class=\"insert\">Отчество</td>\n" +
                    "      <td><input type=\"text\" id=\"date\" required placeholder=\"Введите отчество\"  name=\"patronymic\" size=\"50\"/></td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "      <td class=\"insert\">Должность</td>\n" +
                    "      <td><input type=\"text\" id=\"country\" required placeholder=\"Введите должность\" name=\"post\" size=\"50\"/></td>\n" +
                    "    </tr>\n" +
                    "    </tbody>\n" +
                    "  </table>\n" +
                    "\n" +
                    "<input class=\"button\" type=\"reset\" value=\"Очистить\" name=\"clear\"/>\n" +
                    "&nbsp;&nbsp;\n" +
                    "<input class=\"button\" type=\"submit\" value=\"Сохранить\" name=\"submit\"/>\n" +
                    "&nbsp;&nbsp;");
            //RequestDispatcher view = request.getRequestDispatcher("hello.jsp");
            //view.forward(request,response);
        }

    }*/
    public static void main(String[] args) throws IOException {
    /*    Server server =null;
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
        }*/
        // server JSP//
        /*
        ServletHolder sh = new ServletHolder(ServletContainer.class);
        sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        sh.setInitParameter("com.sun.jersey.config.property.packages", "rest");//Set the package where the services reside
        sh.setInitParameter("com.sun.jersey.config.property.JSPTemplatesBasePath", "/WEB-INF/jsp");
        sh.setInitParameter("com.sun.jersey.config.property.WebPageContentRegex", "/(resources|(WEB-INF/jsp))/.*");

        sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
        Server server =null;
        try {
            server = new Server(8080);
            ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
            context.setBaseResource(Resource.newResource(new File("./web")));
            context.setAliases(true);
            context.addServlet(sh, "/*");
            context.addServlet(sh, "/rest/*");
            server.start();
            server.join();
        } catch (Exception e){
            try{
                if(server!=null)
                    server.stop();
            }  catch (Exception e1){
                e1.printStackTrace();
            }
        }*/

        Server server = new Server(8080);
        //URI baseUri = getWebRootResourceUri();

        // Set JSP to use Standard JavaC always
        //System.setProperty("org.apache.jasper.compiler.disablejsr199", "false");
        WebAppContext context = new WebAppContext();
        context.setDescriptor("web/WEB-INF/web.xml");
        context.setResourceBase("web");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
        context.setWar("web/jetty.war");
        server.setHandler(context);
        try {
            server.start();
            server.join();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                server.stop();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    private URI getWebRootResourceUri() throws FileNotFoundException, URISyntaxException
    {
        URL indexUri = this.getClass().getResource(WEBROOT_INDEX);
        if (indexUri == null)
        {
            throw new FileNotFoundException("Unable to find resource " + WEBROOT_INDEX);
        }
        // Points to wherever /webroot/ (the resource) is
        return indexUri.toURI();
    }


}
