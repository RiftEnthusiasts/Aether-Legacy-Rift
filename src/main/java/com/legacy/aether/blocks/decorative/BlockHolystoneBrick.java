package com.legacy.aether.blocks.decorative;

import com.legacy.aether.mixin.access.BlockPropertiesInvoker;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockHolystoneBrick extends Block
{

	public BlockHolystoneBrick() 
	{
		super(
				((BlockPropertiesInvoker)Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5F, 10.0F))
						.sound(SoundType.STONE)
		);
	}

}