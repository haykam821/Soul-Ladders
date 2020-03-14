package io.github.haykam821.soulladders;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.LadderBlock;
import net.minecraft.sound.BlockSoundGroup;

public class SoulLadderBlock extends LadderBlock {
	public SoulLadderBlock() {
		super(FabricBlockSettings.copy(Blocks.LADDER).sounds(BlockSoundGroup.SOUL_SAND).build());
	}
}