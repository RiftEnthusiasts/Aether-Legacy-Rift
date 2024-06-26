package com.legacy.aether.blocks.decorative;

import com.legacy.aether.mixin.access.BlockPropertiesInvoker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockQuicksoilGlass extends BlockGlass
{

	public BlockQuicksoilGlass()
	{
		super(
				((BlockPropertiesInvoker) ((BlockPropertiesInvoker) Block.Properties.create(Material.GLASS).slipperiness(1.1F))
						.lightValue(14).hardnessAndResistance(0.2F, -1.0F))
						.sound(SoundType.GLASS));
	}

}