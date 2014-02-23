package ad.Genis231.Render.Blocks;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import ad.Genis231.Models.Blocks.ITable1Model;
import ad.Genis231.TileEntity.model.ITable1;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ITableRenderer1 extends TileEntitySpecialRenderer {
	
	private static ITable1Model ITableModel = new ITable1Model();
	public static long speed = 0x3FFF;
	
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		if (tileEntity instanceof ITable1) {
			float rotation = (float) (360.0 * (System.currentTimeMillis() & speed) / speed);
			
			block(x, y, z, 1.0F);
			circle(x, y, z, 1.0F, rotation);
		}
	}
	
	public static void block(double x, double y, double z, float scale) {
		GL11.glPushMatrix();
		
		ITableHelper.block(x, y, z, scale);
		
		// Render
		ITableModel.renderPart(0);
		GL11.glPopMatrix();
	}
	
	public static void circle(double x, double y, double z, float scale, float rotate) {
		GL11.glPushMatrix();
		
		ITableHelper.Circle(x, y, z, scale, rotate);
		
		// Render
		ITableModel.renderPart(1);
		GL11.glPopMatrix();
	}
}
