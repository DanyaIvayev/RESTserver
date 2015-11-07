package rest;

/**
 * Created by ����� on 06.11.2015.
 */

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.servlet.RequestDispatcher;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;
import dto.Meeting;
import dto.Participant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;

@Path("/meeting")
public class MeetingSvc {

    @Context
    ServletContext _context;
    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @GET
    @Path("/getMeeting")
    @Produces(MediaType.APPLICATION_JSON)
    public Meeting getMeeting() {
        Meeting meeting = new Meeting();
        return null;
    }

    @POST
    @Path("/setMeeting")

   // @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Viewable setParticipant(String data) {
        Meeting meeting = null;
        Response response =null;
        try {

            String decodedValue1 = URLDecoder.decode(data, "UTF-8");
            String[] splitStr = decodedValue1.split("[=&]");
            meeting = new Meeting();
            meeting.setName(splitStr[1]);
            meeting.setDescription(splitStr[3]);
            meeting.setBeginData(splitStr[5]);
            meeting.setEndData(splitStr[7]);
            String priority = splitStr[9];
            Meeting.Priority p = meeting.getPriority();
            switch (priority) {
                case "Срочная": {
                    p = Meeting.Priority.URGENT;
                } break;
                case "Плановая": {
                    p = Meeting.Priority.ROUTINE;
                }break;
                case "По возможности": {
                    p = Meeting.Priority.POSSIBLE;
                }break;
            }
            java.net.URI location = new java.net.URI("/");
            response= Response.temporaryRedirect(location).build();

        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        }  catch (URISyntaxException e){
            e.printStackTrace();
        }finally {
            //return response;
            return new Viewable("/", "/");
//            try {
//                RequestDispatcher rd = _context.getRequestDispatcher("/");
//                rd.forward(request, response);
//            } catch(ServletException se){
//                se.printStackTrace();
//            } catch(IOException io){
//                io.printStackTrace();
//            }
            //return meeting;

        }

    }

}
