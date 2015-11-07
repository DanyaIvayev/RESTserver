package dto;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Дамир on 06.11.2015.
 */
@XmlRootElement
public class Meeting {
    public enum Priority {URGENT, ROUTINE, POSSIBLE}
    private String name;
    private String description;
    private String beginData;
    private String endData;
    private List<Participant> participants;
    Priority priority = Priority.URGENT;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeginData() {
        return beginData;
    }

    public void setBeginData(String beginData) {
        this.beginData = beginData;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public String getEndData() {

        return endData;
    }

    public void setEndData(String endData) {
        this.endData = endData;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("{" +"\"name\":");
        result.append("\""+name + "\"").append(", \"description\":'").append("\""+ description + "\"")
                .append(", \"beginData\":" +"\""+ beginData + "\""+
                ", \"endData\":" + "\""+ endData + "\""+
                ", \"participants\":" +"[");

        for(Participant p : participants){
            result.append(participants.toString()+", ");
        }
        result.append("], "+priority.toString()+"}");
        return result.toString();
    }
}
