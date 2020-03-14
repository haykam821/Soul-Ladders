package io.github.haykam821.soulladders;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {
	public static Tag<Block> SOUL_SPEED_CLIMBABLE = TagRegistry.block(new Identifier("soulladders", "soul_speed_climbable"));

	@Override
	public void onInitialize() {
		Identifier id = new Identifier("soulladders", "soul_ladder");

		Block block = Registry.register(Registry.BLOCK, id, new SoulLadderBlock());
		Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(ItemGroup.DECORATIONS)));
	}
}