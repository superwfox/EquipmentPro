package sudark2.Sudark.equipmentPro;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import static sudark2.Sudark.equipmentPro.EquipmentDisplay.*;
import static sudark2.Sudark.equipmentPro.EquipmentPro.bls;
import static sudark2.Sudark.equipmentPro.EquipmentPro.get;

public class Display implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player pl = e.getPlayer();

        for (String style : checkEquipment.styles) {

            if (!pl.hasMetadata(style)) continue;

            int turn = 0;
            for (String bool : pl.getMetadata(style).get(0).asString().split(",")) {
                boolean bl = bool.equals("1");
                turn++;

                if (bl) {
                    apply(pl, style, turn);
                }

            }

        }

    }

    public static void apply(Player pl, String style, int turn) {
        switch (style) {
            case "obsidian":
                switch (turn) {
                    case 1 -> show(pl, obsidianH);
                    case 2 -> show(pl, obsidianC);
                    case 3 -> show(pl, obsidianL);
                    case 4 -> show(pl, obsidianB);
                }
                break;

        }
    }

    public static void show(Player pl, Effect[] effects) {

        for (Effect effect : effects) {
            final BlockDisplay[] bl = {null};

            if (pl.getMetadata("EP") != null && pl.getMetadata("EP").getFirst().asBoolean()) return;

            new BukkitRunnable() {
                @Override
                public void run() {

                    if (bl[0] == null) {
                        spawn(pl, effect, bl[0]);
                    } else {
                        move(pl, effect, bl[0]);
                    }

                }
            }.runTaskTimer(get(), 0, 0L);
            pl.setMetadata("EP", new FixedMetadataValue(get(), true));

            bls.add(bl[0]);
        }

    }

    public static void spawn(Player pl, Effect effect, BlockDisplay bl) {
        float dx = effect.x();
        float dy = effect.y();
        float dz = effect.z();

        Location loc = pl.getLocation();

        loc.add(dx, dy, dz);
        bl = (BlockDisplay) loc.getWorld().spawnEntity(loc, EntityType.BLOCK_DISPLAY);

        bl.setBlock(effect.getMaterial().createBlockData());
        bl.setTransformation(effect.getTransformation());

        bl.setTeleportDuration(4);
        bl.setInterpolationDuration(4);
    }

    public static void move(Player pl, Effect effect, BlockDisplay bl) {
        Location loc = pl.getLocation();

        float dx = effect.x();
        float dy = effect.y();
        float dz = effect.z();

        loc.add(dx, dy, dz);
        bl.teleport(loc);
    }

}
