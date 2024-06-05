package com.legacy.aether.world.biome.builder;

import com.legacy.aether.blocks.BlocksAether;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;

public class AetherSurfaceBuilderConfig implements ISurfaceBuilderConfig
{

	@Override
	public IBlockState getUnderMaterial()
	{
		return BlocksAether.aether_dirt.getDefaultState();
	}

	@Override
	public IBlockState getTopMaterial()
	{
		return BlocksAether.aether_grass.getDefaultState();
	}

}