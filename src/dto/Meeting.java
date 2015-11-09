package dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ����� on 06.11.2015.
 */
@XmlRootElement
public class Meeting {
    public enum Priority {URGENT, ROUTINE, POSSIBLE}

    private String name;
    private String description;
    private String beginData;
    private String endData;
    private ArrayList<Participant> participants;
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

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public void addParticipant(Participant participant){
        if(participants==null){
            participants = new ArrayList<Participant>();
        }
        participants.add(participant);
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
        StringBuffer result = new StringBuffer("{" + "\"name\":");
        result.append("\"" + name + "\"").append(", \"description\":").append("\"" + description + "\"")
                .append(", \"beginData\":" + "\"" + beginData + "\"" +
                        ", \"endData\":" + "\"" + endData + "\"");
        if (participants != null) {
            result.append(", \"participants\":" );

            for (Participant p : participants) {
                result.append(participants.toString() + ", ");
            }

        }
        result.append(", \"priority\":\"" + priority.toString() + "\"}");
        return result.toString();
    }
}
