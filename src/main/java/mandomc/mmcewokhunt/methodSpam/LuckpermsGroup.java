package mandomc.mmcewokhunt.methodSpam;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.InheritanceNode;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class LuckpermsGroup {

    private static final LuckPerms luckPerms = getServer().getServicesManager().load(LuckPerms.class);

    /*public LuckpermsGroup(LuckPerms luckPerms){
        LuckpermsGroup.luckPerms = luckPerms;
    }*/

    public static void addGroup(Player player, String string){

        // Get a group object for the group name.
        Group group = luckPerms.getGroupManager().getGroup(string);

        // Group doesn't exist?
        if (group != null) {
            // Load, modify & save the user in LuckPerms.
            luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {

                // Remove all other inherited groups the user had before.
                user.data().clear(NodeType.INHERITANCE::matches);

                // Create a node to add to the player.
                Node node = InheritanceNode.builder(group).build();

                // Add the node to the user.
                user.data().add(node);

                });
        }
    }
}
