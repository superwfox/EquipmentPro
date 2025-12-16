package sudark2.Sudark.equipmentPro.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

import static sudark2.Sudark.equipmentPro.Menu.Menu.initMenu;

public class CommandHander implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player pl) {
            String operation = args[0];

            if (Objects.equals(operation, "menu")) {
                initMenu(pl);
            }
            return true;
        }

        return true;
    }

}

