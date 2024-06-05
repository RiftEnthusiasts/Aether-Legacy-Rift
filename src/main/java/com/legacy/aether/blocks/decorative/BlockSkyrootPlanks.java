package com.legacy.aether.blocks.decorative;

import com.legacy.aether.mixin.access.BlockPropertiesInvoker;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSkyrootPlanks extends Block
{

	public BlockSkyrootPlanks()
	{
		super(
				((BlockPropertiesInvoker) Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 5.0F))
						.sound(SoundType.WOOD)
		);
	}

}