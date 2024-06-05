package com.legacy.aether.blocks.dungeon;

import com.legacy.aether.mixin.access.BlockPropertiesInvoker;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockDungeon extends Block
{

	public BlockDungeon(boolean isLocked) 
	{
		super(
				((BlockPropertiesInvoker) Properties.create(Material.ROCK).hardnessAndResistance(isLocked ? -1.0F : 0.5F, 6000000.0F))
						.sound(SoundType.STONE)
		);
	}

}