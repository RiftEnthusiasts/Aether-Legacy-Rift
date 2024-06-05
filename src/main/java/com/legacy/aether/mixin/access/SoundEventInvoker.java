package com.legacy.aether.mixin.access;


import net.minecraft.util.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SoundEvent.class)
public interface SoundEventInvoker {
    @Invoker("register")
    public static void register(String string) {
        throw new AssertionError();
    }
}