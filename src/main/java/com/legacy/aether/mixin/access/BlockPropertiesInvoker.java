package com.legacy.aether.mixin.access;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Block.Properties.class)
public interface BlockPropertiesInvoker {
    @Invoker("tickRandomly")
    public Block.Properties tickRandomly();
    @Invoker("sound")
    public Block.Properties sound(SoundType soundTypeIn);
    @Invoker("lightValue")
    public Block.Properties lightValue(int lightValueIn);
}
