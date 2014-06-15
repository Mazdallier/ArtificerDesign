package ad.Genis231.Render.Blocks;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import ad.Genis231.Models.Blocks.PipeModel;
import ad.Genis231.Refrence.textures;
import ad.Genis231.TileEntity.PipeTileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class PipeRenderer extends TileEntitySpecialRenderer {
	
	private PipeModel model = new PipeModel();
	
	@Override public void renderTileEntityAt(TileEntity tile, double posX, double posY, double posZ, float tick) {
		if (tile instanceof PipeTileEntity) {
			
			glPushMatrix();
			
			// Scale, Translate, Rotate
			glScalef(1.0F, 1.0F, 1.0F);
			glTranslatef((float) posX + 0.5F, (float) posY + 0.0F, (float) posZ + 0.5F);
			
			// Bind texture
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures.Pipe);
			
			// Render
			int i = 0;
			for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				TileEntity temp = tile.getWorldObj().getTileEntity((int) tile.xCoord + dir.offsetX, (int) tile.yCoord + dir.offsetY, (int) tile.zCoord + dir.offsetZ);
				
				if (temp == null)
					model.renderPart(i, false);
				else {
					boolean inv = temp instanceof IInventory;
					model.renderPart(i, temp instanceof PipeTileEntity || inv);
				}
				
				i++;
			}
			
			glPopMatrix();
		}
	}
}
