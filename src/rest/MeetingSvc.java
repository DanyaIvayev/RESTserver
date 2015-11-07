package rest;

/**
 * Created by ����� on 06.11.2015.
 */
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.Meeting;
import dto.Participant;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Path("/meeting")
public class MeetingSvc {
    @GET
    @Path("/getMeeting")
    @Produces(MediaType.APPLICATION_JSON)
    public Meeting getMeeting(){
        Meeting meeting = new Meeting();
        return null;
    }

    @POST
    @Path("/setMeeting")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Meeting setParticipant(String data) {
        Meeting meeting =null;
        try {
            //String ecodedValue1 = URLEncoder.encode(data, "UTF-8");
            String decodedValue1 = URLDecoder.decode(data, "UTF-8");
            String[] splitStr = decodedValue1.split("[=&]");
           /* participant = new Participant();
            participant.setLastName(splitStr[1]);
            participant.setFirstName(splitStr[3]);
            participant.setPatronymic(splitStr[5]);
            participant.setPost(splitStr[7]);*/

        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } finally {
            return meeting;
        }

    }

}
