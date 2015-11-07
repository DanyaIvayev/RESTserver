package rest;

/**
 * Created by ����� on 07.11.2015.
 */
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.Meeting;
import dto.Participant;
@Stateless
@Path("/")
public class MainPageSvc {
    @GET
    @Produces(MediaType.TEXT_HTML+";charset=UTF-8")
    public String sayHtmlHello() {
        return "<html><head>\n" +
                " <meta http-equiv=\"CONTENT-TYPE\" content=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\">\n" +
                "    <title>MEETING APP</title>\n" +
                "</head>\n" + "<body><form action=\"participant/setParticipant\" method=\"POST\"><h1 >�������� �������</h1>\n" +
                "  <table class=\"insert\">\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "      <td class=\"insert\">��������</td>\n" +
                "      <td><input type=\"text\" id=\"name\" required placeholder=\"������� ��������\" name=\"name\" size=\"80\"/></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td class=\"insert\">��������</td>\n" +
                "      <td><input type=\"text\" id=\"discription\" required placeholder=\"������� ��������\" name=\"discription\"size=\"80\"/></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td class=\"insert\">���� ������</td>\n" +
                "      <td><input type=\"text\" id=\"begindate\" required placeholder=\"������� ���� (����-��-��)\" pattern=\"^(19|20)\\d\\d-((0((1-(0[1-9]|[12][0-9]|3[01])$)|(2-(0[1-9]|1[0-9]|2[0-8])$)|([3-9]-(0[1-9]|[12][0-9]|3[01])$)))|(1[012]-(0[1-9]|[12][0-9]|3[01])$))$\" name=\"begindate\" size=\"80\"/></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td class=\"insert\">���� �����</td>\n" +
                "      <td><input type=\"text\" id=\"enddate\" required placeholder=\"������� ���� (����-��-��)\" pattern=\"^(19|20)\\d\\d-((0((1-(0[1-9]|[12][0-9]|3[01])$)|(2-(0[1-9]|1[0-9]|2[0-8])$)|([3-9]-(0[1-9]|[12][0-9]|3[01])$)))|(1[012]-(0[1-9]|[12][0-9]|3[01])$))$\" name=\"enddate\" size=\"80\"/></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td class=\"insert\">���������</td>\n" +
                "      <td><input type=\"text\" id=\"priority\" required placeholder=\"������� ��������� (�������, ��������, �� �����������)\" pattern=\"^(��������|�������|�� �����������)$\" name=\"priority\" size=\"80\"/></td>\n" +
                "    </tr>\n" +
                "    </tbody>\n" +
                "  </table>\n" +
                "\n" +
                "<input class=\"button\" type=\"reset\" value=\"��������\" name=\"clear\"/>\n" +
                "&nbsp;&nbsp;\n" +
                "<input class=\"button\" type=\"submit\" value=\"���������\" name=\"submit\"/>\n" +
                "&nbsp;&nbsp;</form></body></html>";
    }

}
