package ro.pub.cs.idp;

/**
 * Created by stancioi on 5/15/2016.
 */
public class Invite {

    private String inviterId;
    private String groupId;

    public Invite(String inviterId, String groupId) {
        this.inviterId = inviterId;
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }
}
