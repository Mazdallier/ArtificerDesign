package ad.Genis231.Render.Models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

//Template version 1.1
//Java generated by Techne
//Keep in mind that you still need to fill in some blanks
//- ZeuX

public class VampModel extends ModelBase {
	//fields
	ModelRenderer Foot_Left;
	ModelRenderer Foot_Right;
	ModelRenderer Leg_Left;
	ModelRenderer Right_Leg;
	ModelRenderer Body;
	ModelRenderer Neck;
	ModelRenderer Head;
	ModelRenderer Eye_1;
	ModelRenderer Eye_2;
	ModelRenderer Arm_R_1;
	ModelRenderer Arm_R_2;
	ModelRenderer Arm_L_1;
	ModelRenderer Arm_L_2;
	
	public VampModel()
	{
		textureWidth = 64;
		textureHeight = 256;
		
		Foot_Left = new ModelRenderer(this, 0, 189);
		Foot_Left.addBox(0F, 0F, 0F, 6, 1, 4);
		Foot_Left.setRotationPoint(-1F, 23F, -6F);
		Foot_Left.setTextureSize(64, 256);
		Foot_Left.mirror = true;
		setRotation(Foot_Left, 0F, 0F, 0F);
		Foot_Right = new ModelRenderer(this, 0, 179);
		Foot_Right.addBox(0F, 0F, 0F, 6, 1, 4);
		Foot_Right.setRotationPoint(-1F, 23F, 4F);
		Foot_Right.setTextureSize(64, 256);
		Foot_Right.mirror = true;
		setRotation(Foot_Right, 0F, 0F, 0F);
		Leg_Left = new ModelRenderer(this, 0, 143);
		Leg_Left.addBox(0F, 0F, 0F, 3, 8, 2);
		Leg_Left.setRotationPoint(0F, 15F, 5F);
		Leg_Left.setTextureSize(64, 256);
		Leg_Left.mirror = true;
		setRotation(Leg_Left, 0F, 0F, 0F);
		Right_Leg = new ModelRenderer(this, 0, 160);
		Right_Leg.addBox(0F, 0F, 0F, 3, 8, 2);
		Right_Leg.setRotationPoint(0F, 15F, -5F);
		Right_Leg.setTextureSize(64, 256);
		Right_Leg.mirror = true;
		setRotation(Right_Leg, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 0, 113);
		Body.addBox(0F, 0F, 0F, 3, 15, 12);
		Body.setRotationPoint(0F, 0F, -5F);
		Body.setTextureSize(64, 256);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		Neck = new ModelRenderer(this, 0, 24);
		Neck.addBox(0F, 0F, 0F, 3, 2, 4);
		Neck.setRotationPoint(0F, -2F, -1F);
		Neck.setTextureSize(64, 256);
		Neck.mirror = true;
		setRotation(Neck, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 22, 7);
		Head.addBox(0F, 0F, 0F, 3, 6, 6);
		Head.setRotationPoint(0F, -8F, -2F);
		Head.setTextureSize(64, 256);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Eye_1 = new ModelRenderer(this, 0, 13);
		Eye_1.addBox(0F, 0F, 0F, 1, 1, 1);
		Eye_1.setRotationPoint(3F, -7F, -1F);
		Eye_1.setTextureSize(64, 256);
		Eye_1.mirror = true;
		setRotation(Eye_1, 0F, 0F, 0F);
		Eye_2 = new ModelRenderer(this, 0, 0);
		Eye_2.addBox(0F, 0F, 0F, 1, 1, 1);
		Eye_2.setRotationPoint(3F, -7F, 2F);
		Eye_2.setTextureSize(64, 256);
		Eye_2.mirror = true;
		setRotation(Eye_2, 0F, 0F, 0F);
		Arm_R_1 = new ModelRenderer(this, 0, 59);
		Arm_R_1.addBox(0F, 0F, 0F, 2, 2, 4);
		Arm_R_1.setRotationPoint(1F, 0F, 7F);
		Arm_R_1.setTextureSize(64, 256);
		Arm_R_1.mirror = true;
		setRotation(Arm_R_1, 0F, 0F, 0F);
		Arm_R_2 = new ModelRenderer(this, 0, 33);
		Arm_R_2.addBox(0F, 0F, 0F, 2, 13, 2);
		Arm_R_2.setRotationPoint(1F, 0F, 11F);
		Arm_R_2.setTextureSize(64, 256);
		Arm_R_2.mirror = true;
		setRotation(Arm_R_2, 0F, 0F, 0F);
		Arm_L_1 = new ModelRenderer(this, 0, 100);
		Arm_L_1.addBox(0F, 0F, 0F, 2, 2, 4);
		Arm_L_1.setRotationPoint(1F, 0F, -9F);
		Arm_L_1.setTextureSize(64, 256);
		Arm_L_1.mirror = true;
		setRotation(Arm_L_1, 0F, 0F, 0F);
		Arm_L_2 = new ModelRenderer(this, 0, 76);
		Arm_L_2.addBox(0F, 0F, 0F, 2, 13, 2);
		Arm_L_2.setRotationPoint(1F, 0F, -11F);
		Arm_L_2.setTextureSize(64, 256);
		Arm_L_2.mirror = true;
		setRotation(Arm_L_2, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Foot_Left.render(f5);
		Foot_Right.render(f5);
		Leg_Left.render(f5);
		Right_Leg.render(f5);
		Body.render(f5);
		Neck.render(f5);
		Head.render(f5);
		Eye_1.render(f5);
		Eye_2.render(f5);
		Arm_R_1.render(f5);
		Arm_R_2.render(f5);
		Arm_L_1.render(f5);
		Arm_L_2.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
}
