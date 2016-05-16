package ro.pub.cs.idp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stancioi on 5/1/2016.
 */
public class GlobalModel {

    public static Map<ConversationParticipants, List<String>> messages = new HashMap<>();
    public static Map<Group, List<String>> groupMessages = new HashMap<>();
    public static Map<String, List<Invite>> invites = new HashMap<>();
}
