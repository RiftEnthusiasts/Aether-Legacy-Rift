package com.legacy.aether.mixin;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTrackerEntry;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSpawnObject;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.legacy.aether.entities.block.EntityFloatingBlock;
import com.legacy.aether.entities.projectile.EntityDart;
import com.legacy.aether.entities.projectile.EntityEnchantedDart;
import com.legacy.aether.entities.projectile.EntityGoldenDart;
import com.legacy.aether.entities.projectile.EntityPoisonDart;
import com.legacy.aether.entities.projectile.EntityPoisonNeedle;

import java.util.Iterator;
import java.util.UUID;

@Mixin(EntityTrackerEntry.class)
public class MixinEntityTrackerEntry 
{
	@Nullable
	private Entity getEntityByUUID(UUID uuid) {
		Entity entity = null;

		/* TODO: Probably broken, reimplement later */

		Iterator it = Minecraft.getInstance().world.getServer().getWorlds().iterator();

		while (it.hasNext()) {
			entity = ((WorldServer) it).getEntityFromUuid(uuid);
			if (entity != null) {
				break;
			}
		}

		return entity;
	}

    @Shadow @Final private Entity trackedEntity;

    @Inject(method = "createSpawnPacket", at = @At("INVOKE"), cancellable = true)
	private void createAetherSpawnPacket(CallbackInfoReturnable<Packet<?>> info)
	{
		if (this.trackedEntity instanceof EntityFloatingBlock)
		{
			EntityFloatingBlock floatingBlock = (EntityFloatingBlock) this.trackedEntity;
			info.setReturnValue(new SPacketSpawnObject(this.trackedEntity, 583, Block.getStateId(floatingBlock.getBlockstate())));
		}
		else if (this.trackedEntity instanceof EntityGoldenDart)
		{
			Entity dart = getEntityByUUID(((EntityDart) this.trackedEntity).shootingEntity);
			info.setReturnValue(new SPacketSpawnObject(this.trackedEntity, 584, 1 + (dart == null ? this.trackedEntity.getEntityId() : dart.getEntityId())));
		}
		else if (this.trackedEntity instanceof EntityEnchantedDart)
		{
			Entity dart = getEntityByUUID(((EntityDart) this.trackedEntity).shootingEntity);
			info.setReturnValue(new SPacketSpawnObject(this.trackedEntity, 585, 1 + (dart == null ? this.trackedEntity.getEntityId() : dart.getEntityId())));
		}
		else if (this.trackedEntity instanceof EntityPoisonNeedle)
		{
			Entity dart = getEntityByUUID(((EntityDart) this.trackedEntity).shootingEntity);
			info.setReturnValue(new SPacketSpawnObject(this.trackedEntity, 586, 1 + (dart == null ? this.trackedEntity.getEntityId() : dart.getEntityId())));
		}
		else if (this.trackedEntity instanceof EntityPoisonDart)
		{
			Entity dart = getEntityByUUID(((EntityDart) this.trackedEntity).shootingEntity);
			info.setReturnValue(new SPacketSpawnObject(this.trackedEntity, 587, 1 + (dart == null ? this.trackedEntity.getEntityId() : dart.getEntityId())));
		}
	}

}