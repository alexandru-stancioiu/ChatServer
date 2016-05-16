package ro.pub.cs.idp;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by stancioi on 5/15/2016.
 */

@RestController
public class InviteUserController {

    @RequestMapping(method = RequestMethod.POST, value = "/inviteUser")
    public void inviteUser(@RequestParam String groupId, @RequestParam String friendId, @RequestParam String inviterId) {

        List<Invite> invites = GlobalModel.invites.get(friendId);
        if (invites == null) {
            invites = new LinkedList<>();
            GlobalModel.invites.put(friendId, invites);
        }

        invites.add(new Invite(inviterId, groupId));

    }
}
