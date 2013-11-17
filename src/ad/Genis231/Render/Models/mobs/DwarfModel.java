package ad.Genis231.Render.Models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

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
        
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 6, 5, 6);
        head.setRotationPoint(1F, 14F, 1F);
        head.setTextureSize(32, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 41);
        body.addBox(-4F, 0F, -2F, 8, 6, 4);
        body.setRotationPoint(0F, 11F, 0F);
        body.setTextureSize(32, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 17, 27);
        rightarm.addBox(-3F, -2F, -2F, 3, 6, 4);
        rightarm.setRotationPoint(-4F, 13F, 0F);
        rightarm.setTextureSize(32, 64);
        rightarm.mirror = true;
        setRotation(rightarm, 0.3490659F, 0F, 0F);
        leftarm = new ModelRenderer(this, 17, 16);
        leftarm.addBox(-1F, -2F, -2F, 3, 6, 4);
        leftarm.setRotationPoint(5F, 13F, 0F);
        leftarm.setTextureSize(32, 64);
        leftarm.mirror = true;
        setRotation(leftarm, -0.3490659F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 28);
        rightleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        rightleg.setRotationPoint(-2F, 17F, 0F);
        rightleg.setTextureSize(32, 64);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        leftleg.setRotationPoint(2F, 17F, 0F);
        leftleg.setTextureSize(32, 64);
        leftleg.mirror = true;
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
    
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
    
}
