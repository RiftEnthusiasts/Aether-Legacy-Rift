package com.legacy.aether.blocks.natural.ore;

import java.util.Random;

import com.legacy.aether.mixin.access.BlockPropertiesInvoker;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import com.legacy.aether.item.ItemsAether;

public class BlockZaniteOre extends Block
{

	public BlockZaniteOre()
	{
		super(
                ((BlockPropertiesInvoker) Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 5.0F))
                        .sound(SoundType.STONE)
        );
	}

	@Override
	public IItemProvider getItemDropped(IBlockState stateIn, World worldIn, BlockPos posIn, int fortune)
	{
		return ItemsAether.zanite_gemstone;
	}

	@Override
	public void dropBlockAsItemWithChance(IBlockState stateIn, World worldIn, BlockPos posIn, float chanceIn, int fortuneIn)
	{
		super.dropBlockAsItemWithChance(stateIn, worldIn, posIn, chanceIn, fortuneIn);

        /*
		TODO:
		 rollback to super.dropXpOnBlockBreak(worldIn, posIn, MathHelper.getInt(new Random(), 3, 5));
		 */
		super.dropXpOnBlockBreak(worldIn, posIn, MathHelper.getInt(new Random().toString(), 3, 5));
	}

	@Override
    public int getItemsToDropCount(IBlockState stateIn, int fortuneIn, World worldIn, BlockPos posIn, Random randomIn)
    {
        if (fortuneIn > 0)
        {
            int i = randomIn.nextInt(fortuneIn + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return super.getItemsToDropCount(stateIn, fortuneIn, worldIn, posIn, randomIn) * (i + 1);
        }
        else
        {
            return super.getItemsToDropCount(stateIn, fortuneIn, worldIn, posIn, randomIn);
        }
    }

}