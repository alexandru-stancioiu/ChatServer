package ro.pub.cs.idp;

import java.util.List;

/**
 * Created by stancioi on 5/1/2016.
 */
public class ConversationParticipants {

    private List<String> participants;

    public ConversationParticipants(List<String> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationParticipants that = (ConversationParticipants) o;

        return participants != null ? participants.equals(that.participants) : that.participants == null;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (String s : participants)
        {
            result = result * prime + s.hashCode();
        }
        return result;
    }
}
