package com.legacy.aether.mixin.access;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Block.class)
public interface BlockInvoker {
    @Invoker("register")
    public static void register(ResourceLocation resourceLocation, Block blockIn) {
        throw new AssertionError();
    }
}
