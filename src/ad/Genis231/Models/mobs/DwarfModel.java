package ad.Genis231.Models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class DwarfModel extends ModelBase {
    // fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    
    public DwarfModel() {
        textureWidth = 32;
        textureHeight = 64;
        
        head.setTextureSize(textureWidth, textureHeight);
        body.setTextureSize(textureWidth, textureHeight);
        rightarm.setTextureSize(textureWidth, textureHeight);
        leftarm.setTextureSize(textureWidth, textureHeight);
        rightleg.setTextureSize(textureWidth, textureHeight);
        leftleg.setTextureSize(textureWidth, textureHeight);
        
        head = new ModelRenderer(this, 0, 0);
        body = new ModelRenderer(this, 0, 41);
        rightarm = new ModelRenderer(this, 17, 27);
        leftarm = new ModelRenderer(this, 17, 16);
        rightleg = new ModelRenderer(this, 0, 28);
        leftleg = new ModelRenderer(this, 0, 16);
        
        head.addBox(-4F, -8F, -4F, 6, 5, 6);
        body.addBox(-4F, 0F, -2F, 8, 6, 4);
        rightarm.addBox(-3F, -2F, -2F, 3, 6, 4);
        leftarm.addBox(-1F, -2F, -2F, 3, 6, 4);
        rightleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        leftleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        
        head.setRotationPoint(1F, 14F, 1F);
        body.setRotationPoint(0F, 11F, 0F);
        rightarm.setRotationPoint(-4F, 13F, 0F);
        leftarm.setRotationPoint(5F, 13F, 0F);
        rightleg.setRotationPoint(-2F, 17F, 0F);
        leftleg.setRotationPoint(2F, 17F, 0F);
        
        head.mirror = true;
        body.mirror = true;
        rightarm.mirror = true;
        leftarm.mirror = true;
        rightleg.mirror = true;
        leftleg.mirror = true;
        
        setRotation(head, 0F, 0F, 0F);
        setRotation(body, 0F, 0F, 0F);
        setRotation(rightarm, 0F, 0F, 0F);
        setRotation(leftarm, 0F, 0F, 0F);
        setRotation(rightleg, 0F, 0F, 0F);
        setRotation(leftleg, 0F, 0F, 0F);
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how "far" arms and legs can swing at most.
     */
    
    public void setRotationAngles(float ticks, float distance, float par3, float par4, float par5, float par6, Entity entity) {
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
