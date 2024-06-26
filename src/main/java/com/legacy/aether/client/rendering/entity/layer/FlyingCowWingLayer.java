package com.legacy.aether.client.rendering.entity.layer;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;

import com.legacy.aether.Aether;
import com.legacy.aether.client.model.FlyingCowWingModel;
import com.legacy.aether.entities.passive.EntityFlyingCow;

public class FlyingCowWingLayer implements LayerRenderer<EntityFlyingCow> 
{

	private static final ResourceLocation TEXTURE = Aether.locate("textures/entity/flying_cow/wings.png");

	private RenderManager renderManager;

	private FlyingCowWingModel model;

	public FlyingCowWingLayer(RenderManager manager)
	{
		this.renderManager = manager;
		this.model = new FlyingCowWingModel();
	}

	@Override
	public void render(EntityFlyingCow cow, float limbSwing, float prevLimbSwing, float partialTicks, float rotation, float interpolateRotation, float prevRotationPitch, float scale)
	{
		this.renderManager.textureManager.bindTexture(TEXTURE);
		this.model.render(cow, limbSwing, prevLimbSwing, rotation, interpolateRotation, prevRotationPitch, scale);
	}

	@Override
	public boolean shouldCombineTextures() 
	{
		return false;
	}

}