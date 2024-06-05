package com.legacy.aether.mixin.access;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Item.class)
public interface ItemInvoker {
    @Invoker("register")
    public static void register(String string, Item itemIn) {
        throw new AssertionError();
    }
    @Invoker("register")
    public static void register(Block block, ItemGroup group) {
        throw new AssertionError();
    }
    @Invoker("register")
    public static void register(Block block, Item item) {
        throw new AssertionError();
    }
}
