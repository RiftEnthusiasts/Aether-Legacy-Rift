package com.legacy.aether.world;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;

import org.dimdev.rift.listener.BiomeAdder;
import org.dimdev.rift.listener.DimensionTypeAdder;

import com.legacy.aether.world.biome.AetherBiome;

public class WorldAether implements BiomeAdder, DimensionTypeAdder
{

	public static AetherBiome aetherBiome;

	public static DimensionType AETHER;

	@Override
	public void registerDimensionTypes()
	{
		AETHER = DimensionTypeAdder.addDimensionType(12, new ResourceLocation("aether_legacy", "aether"), "_aether", AetherDimension::new);
	}

	@Override
	public void registerBiomes()
	{
		aetherBiome = new AetherBiome();

		/*Biome.registerBiome(525, "aether_legacy:aether_highlands", aetherBiome);*/
		IRegistry.BIOME.register(525, new ResourceLocation("aether_legacy", "aether_highlands"), aetherBiome);
	}

	@Override
	public Collection<Biome> getOverworldBiomes()
	{
		return Collections.emptyList();
	}

}