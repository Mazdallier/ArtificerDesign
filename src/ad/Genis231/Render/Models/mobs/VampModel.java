package ad.Genis231.Render.Models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class VampModel extends ModelBase {
	//fields
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape32;
	ModelRenderer Shape34;
	
	public VampModel() {
		textureWidth = 64;
		textureHeight = 64;
		
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(0F, 0F, 0F, 4, 6, 2);
		Shape2.setRotationPoint(0F, 18F, 1F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		
		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(0F, 0F, 0F, 4, 6, 2);
		Shape3.setRotationPoint(0F, 18F, -3F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		
		Shape4 = new ModelRenderer(this, 0, 0);
		Shape4.addBox(0F, 0F, 0F, 16, 16, 16);
		Shape4.setRotationPoint(-8F, 8F, 8F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		
		Shape5 = new ModelRenderer(this, 0, 0);
		Shape5.addBox(0F, 0F, 0F, 4, 8, 8);
		Shape5.setRotationPoint(0F, 10F, -4F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		
		Shape6 = new ModelRenderer(this, 0, 0);
		Shape6.addBox(0F, 0F, 0F, 2, 4, 4);
		Shape6.setRotationPoint(1F, 6F, -2F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape32 = new ModelRenderer(this, 0, 0);
		Shape32.addBox(0F, 0F, 0F, 2, 5, 1);
		Shape32.setRotationPoint(0F, 10F, 4F);
		Shape32.setTextureSize(64, 32);
		Shape32.mirror = true;
		setRotation(Shape32, 0F, 0F, 0.669215F);
		Shape34 = new ModelRenderer(this, 0, 0);
		Shape34.addBox(0F, 0F, 0F, 2, 5, 1);
		Shape34.setRotationPoint(0F, 10F, -5F);
		Shape34.setTextureSize(64, 32);
		Shape34.mirror = true;
		setRotation(Shape34, 0F, 0F, 0.8179294F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape32.render(f5);
		Shape34.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
}
