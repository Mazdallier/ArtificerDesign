package ad.Genis231.Models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class DwarfModel extends ModelBase{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	int tw = 32;
	int th = 64;

	public DwarfModel(){
		textureWidth = tw;
		textureHeight = th;

		head = new ModelRenderer(this,0,0);
		head.addBox(-3F,-5F,-3F,6,5,6);
		head.setRotationPoint(0F,11F,0F);
		head.setTextureSize(tw,th);
		head.mirror = true;
		setRotation(head,0F,0F,0F);

		body = new ModelRenderer(this,0,41);
		body.addBox(-4F,0F,-2F,8,6,4);
		body.setRotationPoint(0F,11F,0F);
		body.setTextureSize(tw,th);
		body.mirror = true;
		setRotation(body,0F,0F,0F);

		rightarm = new ModelRenderer(this,17,27);
		rightarm.addBox(-3F,-2F,-2F,3,6,4);
		rightarm.setRotationPoint(-4F,13F,0F);
		rightarm.setTextureSize(tw,th);
		rightarm.mirror = true;
		setRotation(rightarm,0F,0F,0F);

		leftarm = new ModelRenderer(this,17,16);
		leftarm.addBox(-1F,-2F,-2F,3,6,4);
		leftarm.setRotationPoint(5F,13F,0F);
		leftarm.setTextureSize(tw,th);
		leftarm.mirror = true;
		setRotation(leftarm,0F,0F,0F);

		rightleg = new ModelRenderer(this,0,28);
		rightleg.addBox(-2F,0F,-2F,4,7,4);
		rightleg.setRotationPoint(-2F,17F,0F);
		rightleg.setTextureSize(tw,th);
		rightleg.mirror = true;
		setRotation(rightleg,0F,0F,0F);

		leftleg = new ModelRenderer(this,0,16);
		leftleg.addBox(-2F,0F,-2F,4,7,4);
		leftleg.setRotationPoint(2F,17F,0F);
		leftleg.setTextureSize(tw,th);
		leftleg.mirror = true;
		setRotation(leftleg,0F,0F,0F);
	}

	public void render(Entity entity,float f,float f1,float f2,float f3,float f4,float f5){
		super.render(entity,f,f1,f2,f3,f4,f5);
		setRotationAngles(f,f1,f2,f3,f4,f5,entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
	}

	private void setRotation(ModelRenderer model,float x,float y,float z){
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	/**
	 * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how "far" arms and legs can swing at most.
	 */

	public void setRotationAngles(float ticks,float distance,float par3,float par4,float par5,float par6,Entity entity){
		this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float) Math.PI);

		this.rightarm.rotateAngleX = MathHelper.cos(ticks * 0.6662F + (float) Math.PI) * 2.0F * distance * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(ticks * 0.6662F) * 2.0F * distance * 0.5F;

		this.rightleg.rotateAngleX = MathHelper.cos(ticks * 0.6662F) * 1.4F * distance;
		this.leftleg.rotateAngleX = MathHelper.cos(ticks * 0.6662F + (float) Math.PI) * 1.4F * distance;

		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;

		this.rightleg.rotateAngleY = 0.0F;
		this.leftleg.rotateAngleY = 0.0F;

		this.rightarm.rotateAngleY = 0.0F;
		this.leftarm.rotateAngleY = 0.0F;
	}

}
