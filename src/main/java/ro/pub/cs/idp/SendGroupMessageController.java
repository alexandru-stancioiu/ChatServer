package ro.pub.cs.idp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stancioi on 5/14/2016.
 */
@RestController
public class SendGroupMessageController {

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/sendGroupMessage")
    public void sendMessage(@RequestParam String message, @RequestParam String senderId, @RequestParam String groupId) {

        Group currentGroup = null;
        for (Group group : GlobalModel.groupMessages.keySet()) {
            if (group.getId().equals(groupId)) {
                currentGroup = group;
            }
        }

        List<String> messages = GlobalModel.groupMessages.get(currentGroup);
        messages.add(message);
    }
}
