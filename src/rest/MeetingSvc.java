package rest;

/**
 * Created by Дамир on 06.11.2015.
 */
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.Meeting;
import dto.Participant;
@Path("/meeting")
public class MeetingSvc {
    @GET
    @Path("/getMeeting")
    @Produces(MediaType.APPLICATION_JSON)
    public Meeting getMeeting(){
        Meeting meeting = new Meeting();
        return null;
    }

}
