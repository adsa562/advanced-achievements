package com.hm.achievement.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketFillEvent;

import com.hm.achievement.AdvancedAchievements;
import com.hm.achievement.category.NormalAchievements;

/**
 * Listener class to deal with Milk achievements.
 * 
 * @author Pyves
 *
 */
public class AchieveMilkLavaWaterListener extends AbstractListener implements Listener {

	public AchieveMilkLavaWaterListener(AdvancedAchievements plugin) {

		super(plugin);
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onPlayerBucketFill(PlayerBucketFillEvent event) {

		Player player = event.getPlayer();

		NormalAchievements category;
		Material resultBucket = event.getItemStack().getType();
		if (resultBucket == Material.MILK_BUCKET) {
			category = NormalAchievements.MILKS;
		} else if (resultBucket == Material.LAVA_BUCKET) {
			category = NormalAchievements.LAVABUCKETS;
		} else {
			category = NormalAchievements.WATERBUCKETS;
		}

		if (!shouldEventBeTakenIntoAccountNoCreative(player, category)) {
			return;
		}

		updateStatisticAndAwardAchievementsIfAvailable(player, category, 1);
	}
}