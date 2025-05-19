package sudark2.Sudark.equipmentPro;

import org.bukkit.Location;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import static sudark2.Sudark.equipmentPro.EquipmentDisplay.*;
import static sudark2.Sudark.equipmentPro.EquipmentPro.bls;
import static sudark2.Sudark.equipmentPro.EquipmentPro.get;

public class Display implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player pl = e.getPlayer();

        for (String style : checkEquipment.styles) {

            if (!pl.hasMetadata(style)) continue;

            if (pl.hasMetadata("EP") && pl.getMetadata("EP").getFirst().asBoolean()) return;

            int turn = 0;
            for (String bool : pl.getMetadata(style).get(0).asString().split(",")) {
                turn++;

                if (bool.equals("1")) {
                    apply(pl, style, turn);
                }

            }

            pl.setMetadata("EP", new FixedMetadataValue(get(), true));

        }

    }

    public static void apply(Player pl, String style, int turn) {
        switch (style) {
            case "obsidian":
                switch (turn) {
                    case 1 -> show(pl, obsidianH, true);
                    case 2 -> show(pl, obsidianC, false);
                    case 3 -> show(pl, obsidianL, false);
                    case 4 -> show(pl, obsidianB, false);
                }
                break;
            case "wild":
                switch (turn) {
                    case 1 -> show(pl, wildH, true);
                    case 2 -> show(pl, wildC, false);
                    case 3 -> show(pl, wildL, false);
                    case 4 -> show(pl, wildB, false);
                }
                break;
        }
    }

    public static void show(Player pl, Effect[] effects, Boolean head) {

        for (Effect effect : effects) {
            final BlockDisplay[] bl = {null};

            new BukkitRunnable() {
                @Override
                public void run() {

                    if (!pl.hasMetadata("EP") || !pl.isOnline()) {
                        bl[0].remove();
                        this.cancel();
                        return;
                    }

                    if (bl[0] == null) {
                        bl[0] = spawn(pl, effect);
                    } else if (bl[0].isValid()) {
                        if (head) {
                            moveH(pl, bl[0]);
                        } else {
                            move(pl, bl[0]);
                        }
                    } else {
                        pl.removeMetadata("EP", get());
                        this.cancel();
                    }
                }
            }.runTaskTimer(get(), 1L, 0L);
        }

    }

    public static BlockDisplay spawn(Player pl, Effect effect) {
        Location loc = pl.getLocation();

        BlockDisplay bl = (BlockDisplay) loc.getWorld().spawnEntity(loc, EntityType.BLOCK_DISPLAY);

        bl.setBlock(effect.getMaterial().createBlockData());
        bl.setTransformation(effect.getTransformation());

        bl.setTeleportDuration(0);
        bl.setInterpolationDuration(1);

        bls.add(bl);

        return bl;
    }

    public static void moveH(Player pl, BlockDisplay bl) {
        Location base = pl.getEyeLocation().subtract(0, 2 * p, 0).clone();

//        // 获取玩家朝向的三个轴向量：前、右、上
//        Vector forward = base.getDirection().normalize(); // 面朝方向 (Z轴)
//        Vector up = new Vector(0, 1, 0);
//        Vector right = forward.clone().crossProduct(up).normalize(); // 右边方向 (X轴)
//        up = right.clone().crossProduct(forward).normalize(); // 重新计算垂直方向 (Y轴)
//
//        // 构造相对偏移
//        Vector offset = right.clone().multiply(effect.x())
//                .add(up.clone().multiply(effect.y()))
//                .add(forward.clone().multiply(effect.z()));
//
//        base.add(offset);
        bl.teleport(base);
    }

    public static void move(Player pl, BlockDisplay bl) {
        Location base = pl.getLocation().clone();
        float yaw = base.getYaw();

        // 仅水平 forward 向量
        Vector forward = new Vector(-Math.sin(Math.toRadians(yaw)), 0, Math.cos(Math.toRadians(yaw))).normalize();

        base.setPitch(0);
        bl.teleport(base);
    }


}
