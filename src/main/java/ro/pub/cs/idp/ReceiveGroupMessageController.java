package ro.pub.cs.idp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stancioi on 5/2/2016.
 */

@RestController
public class ReceiveGroupMessageController {

    @RequestMapping(method = RequestMethod.POST, value = "/receiveGroupMessages")
    @ResponseBody
    public String receiveGroupMessages(@RequestParam String groupId) {

        Group currentGroup = null;
        for (Group group : GlobalModel.groupMessages.keySet()) {
            if (group.getId().equals(groupId)) {
                currentGroup = group;
            }
        }

        List<String> groupMessages = GlobalModel.groupMessages.get(currentGroup);

        ObjectMapper objectMapper = new ObjectMapper();
        String messagesJson = null;
        try {
            messagesJson = objectMapper.writeValueAsString(groupMessages);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return messagesJson;
    }
}
