package com.legacy.aether.blocks.decorative;

import com.legacy.aether.mixin.access.BlockPropertiesInvoker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockAmbrosiumTorch extends BlockTorch
{

	public BlockAmbrosiumTorch()
	{
		/* sorry, father, I have sinned... */
		super(
				((BlockPropertiesInvoker)((BlockPropertiesInvoker)((BlockPropertiesInvoker) Block.Properties.create(Material.CIRCUITS))
						.tickRandomly())
						.lightValue(1))
						.sound(SoundType.WOOD)
		);
	}

}