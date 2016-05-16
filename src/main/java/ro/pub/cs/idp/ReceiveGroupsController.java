package ro.pub.cs.idp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by stancioi on 5/3/2016.
 */

@RestController
public class ReceiveGroupsController {

    @RequestMapping(method = RequestMethod.GET, value = "/receiveGroups")
    @ResponseBody
    public String receiveGroups() {

        Collection<Group> groups = GlobalModel.groupMessages.keySet();

        ObjectMapper objectMapper = new ObjectMapper();
        String groupsJson = null;
        try {
            groupsJson = objectMapper.writeValueAsString(groups);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return groupsJson;
    }
}
