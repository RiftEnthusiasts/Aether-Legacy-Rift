package com.legacy.aether.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;

import com.legacy.aether.entities.passive.EntityPhyg;

public class PhygWingModel extends ModelBase
{

    private ModelRenderer leftWingInner = new ModelRenderer(this, 0, 0);
    private ModelRenderer leftWingOuter = new ModelRenderer(this, 20, 0);
    private ModelRenderer rightWingInner = new ModelRenderer(this, 0, 0);
    private ModelRenderer rightWingOuter = new ModelRenderer(this, 40, 0);

    public PhygWingModel()
    {
        this.leftWingInner.addBox(-1.0F, -8.0F, -4.0F, 2, 16, 8, 0.0F);
        this.leftWingOuter.addBox(-1.0F, -8.0F, -4.0F, 2, 16, 8, 0.0F);
        this.rightWingInner.addBox(-1.0F, -8.0F, -4.0F, 2, 16, 8, 0.0F);
        this.rightWingOuter.addBox(-1.0F, -8.0F, -4.0F, 2, 16, 8, 0.0F);

        this.rightWingOuter.rotateAngleY = (float)Math.PI;
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	EntityPhyg pig = ((EntityPhyg)entityIn);

        if (pig.isChild())
        {
            GlStateManager.scalef(1.0F / 2.0F, 1.0F / 2.0F, 1.0F / 2.0F);
            GlStateManager.translatef(0.0F, 24.0F * scale, 0.0F);

            float wingBend = -((float)Math.acos((double)pig.wingFold));
            float y = 32.0F * pig.wingFold / 4.0F;
            float z = -32.0F * (float)Math.sqrt((double)(1.0F - pig.wingFold * pig.wingFold)) / 4.0F;
            float x2 = 0.0F;
            float y2 = y * (float)Math.cos((double)pig.wingAngle) - z * (float)Math.sin((double)pig.wingAngle);
            float y21 = y * (float)Math.sin((double)pig.wingAngle) + z * (float)Math.cos((double)pig.wingAngle);

            this.leftWingInner.setRotationPoint(4.0F + y2, y21 + 12.0F, x2);
            this.rightWingInner.setRotationPoint(-4.0F - y2, y21 + 12.0F, x2);

            y *= 3.0F;
            y2 = y * (float)Math.cos((double)pig.wingAngle) - z * (float)Math.sin((double)pig.wingAngle);
            y21 = y * (float)Math.sin((double)pig.wingAngle) + z * (float)Math.cos((double)pig.wingAngle);

            this.leftWingOuter.setRotationPoint(4.0F + y2, y21 + 12.0F, x2);
            this.rightWingOuter.setRotationPoint(-4.0F - y2, y21 + 12.0F, x2);

            this.leftWingInner.rotateAngleZ = pig.wingAngle + wingBend + ((float)Math.PI / 2F);
            this.leftWingOuter.rotateAngleZ = pig.wingAngle - wingBend + ((float)Math.PI / 2F);
            this.rightWingInner.rotateAngleZ = -(pig.wingAngle + wingBend - ((float)Math.PI / 2F));
            this.rightWingOuter.rotateAngleZ = -(pig.wingAngle - wingBend + ((float)Math.PI / 2F));

            this.leftWingOuter.render(scale);
            this.leftWingInner.render(scale);
            this.rightWingOuter.render(scale);
            this.rightWingInner.render(scale);
        }
        else
        {
        	float wingBend = -((float)Math.acos((double)pig.wingFold));
            float x = 32.0F * pig.wingFold / 4.0F;
            float y = -32.0F * (float)Math.sqrt((double)(1.0F - pig.wingFold * pig.wingFold)) / 4.0F;
            float z = 0.0F;
            float x2 = x * (float)Math.cos((double)pig.wingAngle) - y * (float)Math.sin((double)pig.wingAngle);
            float y2 = x * (float)Math.sin((double)pig.wingAngle) + y * (float)Math.cos((double)pig.wingAngle);

            this.leftWingInner.setRotationPoint(4.0F + x2, y2 + 12.0F, z);
            this.rightWingInner.setRotationPoint(-4.0F - x2, y2 + 12.0F, z);

            x *= 3.0F;
            x2 = x * (float)Math.cos((double)pig.wingAngle) - y * (float)Math.sin((double)pig.wingAngle);
            y2 = x * (float)Math.sin((double)pig.wingAngle) + y * (float)Math.cos((double)pig.wingAngle);

            this.leftWingOuter.setRotationPoint(4.0F + x2, y2 + 12.0F, z);
            this.rightWingOuter.setRotationPoint(-4.0F - x2, y2 + 12.0F, z);

            this.leftWingInner.rotateAngleZ = pig.wingAngle + wingBend + ((float)Math.PI / 2F);
            this.leftWingOuter.rotateAngleZ = pig.wingAngle - wingBend + ((float)Math.PI / 2F);
            this.rightWingInner.rotateAngleZ = -(pig.wingAngle + wingBend - ((float)Math.PI / 2F));
            this.rightWingOuter.rotateAngleZ = -(pig.wingAngle - wingBend + ((float)Math.PI / 2F));

            this.leftWingOuter.render(scale);
            this.leftWingInner.render(scale);
            this.rightWingOuter.render(scale);
            this.rightWingInner.render(scale);
        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {}

}