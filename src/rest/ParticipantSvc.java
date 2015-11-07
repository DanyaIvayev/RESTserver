package rest;

/**
 * Created by ����� on 06.11.2015.
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
@Path("/part")
public class ParticipantSvc {

    /*public String sayHtmlHello() {
        return "<html><head>\n" +
                "    <meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\">\n" +
                "    <title>MEETING APP</title>\n" +
                "</head>\n" + "<body><form action=\"setParticipant\" method=\"POST\"><h1 >Главная страница</h1>\n" +
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
                "&nbsp;&nbsp;</form></body></html>";
    }*/


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
