package ro.pub.cs.idp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stancioi on 4/30/2016.
 */

@RestController
public class SendMessageController {

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/sendMessage")
    public void sendMessage(@RequestParam String message, @RequestParam String senderId, @RequestParam String receiverId) {

        List<String> cpList = new LinkedList<>();
        cpList.add(senderId);
        cpList.add(receiverId);
        Collections.sort(cpList);
        ConversationParticipants cp = new ConversationParticipants(cpList);

        List<String> messages;
        if (!GlobalModel.messages.containsKey(cp)) {
            messages = new LinkedList<>();
            messages.add(message);
            GlobalModel.messages.put(cp, messages);
        } else {
            messages = GlobalModel.messages.get(cp);
            messages.add(message);
        }
    }
}
