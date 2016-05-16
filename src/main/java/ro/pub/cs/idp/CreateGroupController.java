package ro.pub.cs.idp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by stancioi on 5/3/2016.
 */

@RestController
public class CreateGroupController {

    @RequestMapping(method = RequestMethod.POST, value = "/createGroup")
    @ResponseBody
    public String createGroup(@RequestParam String groupName) {
        String uniqueID = UUID.randomUUID().toString();

        Group group = new Group(uniqueID, groupName);
        GlobalModel.groupMessages.put(group, new ArrayList<>());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(group);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
