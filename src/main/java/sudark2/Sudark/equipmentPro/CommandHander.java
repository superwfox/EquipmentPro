package sudark2.Sudark.equipmentPro;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CommandHander implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (sender instanceof CommandSender player) {
            String style = args[0];
            Player pl = (Player) player;

            if (!pl.isOp()) return false;

            ItemStack item = pl.getItemInHand();
            List<String> lore = new ArrayList<>();

            if (item.getLore() != null) lore = item.getLore();
            lore.add(style);
            pl.getItemInHand().setLore(lore);

        }

        return true;
    }
}
