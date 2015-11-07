package rest;

/**
 * Created by Дамир on 06.11.2015.
 */

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;
import dto.Meeting;
import dto.Participant;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.io.*;

@Stateless
@Path("/participant")
public class ParticipantSvc {

    @POST
    @Path("/setParticipant")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Participant setParticipant(String data) {
        Participant participant =null;
        try {
            //String ecodedValue1 = URLEncoder.encode(data, "UTF-8");
            String decodedValue1 = URLDecoder.decode(data, "UTF-8");
            String[] splitStr = decodedValue1.split("[=&]");
            participant = new Participant();
            participant.setLastName(splitStr[1]);
            participant.setFirstName(splitStr[3]);
            participant.setPatronymic(splitStr[5]);
            participant.setPost(splitStr[7]);

        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } finally {
            return participant;
        }

    }

}
