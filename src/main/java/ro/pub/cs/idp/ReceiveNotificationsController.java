package ro.pub.cs.idp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by stancioi on 5/15/2016.
 */

@RestController
public class ReceiveNotificationsController {

    @RequestMapping(method = RequestMethod.POST, value = "/receiveNotifications")
    @ResponseBody
    public String receiveNotifications(@RequestParam String id) {

        List<Invite> invites = GlobalModel.invites.get(id);

        ObjectMapper objectMapper = new ObjectMapper();
        String invitesJson = null;
        try {
            invitesJson = objectMapper.writeValueAsString(invites);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return invitesJson;
    }
}
