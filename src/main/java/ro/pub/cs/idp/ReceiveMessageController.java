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
public class ReceiveMessageController {

    @RequestMapping(method = RequestMethod.POST, value = "/receiveMessages")
    @ResponseBody
    public String receiveMessages(@RequestParam String chatPartnerId, @RequestParam String myId) {
        List<String> cpList = new LinkedList<>();
        cpList.add(myId);
        cpList.add(chatPartnerId);
        Collections.sort(cpList);
        ConversationParticipants cp = new ConversationParticipants(cpList);
        List<String> messages = GlobalModel.messages.get(cp);

        ObjectMapper objectMapper = new ObjectMapper();
        String messagesJson = null;
        try {
            messagesJson = objectMapper.writeValueAsString(messages);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return messagesJson;
    }
}
