package ad.Genis231.Render.Blocks;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import static org.lwjgl.opengl.GL11.*;

import ad.Genis231.Models.Blocks.ITable2Model;
import ad.Genis231.TileEntity.model.ITable2;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT) public class ITableRenderer2 extends TileEntitySpecialRenderer {
	
	private static ITable2Model ITableModel = new ITable2Model();
	public static long speed = ITableRenderer1.speed;
	
	@Override public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
		
		if (tileEntity instanceof ITable2) {
			float rotation = (float) (360.0 * (System.currentTimeMillis() & speed) / speed);
			
			block(x, y, z, 1.0F);
			circle(x, y, z, 1.0F, rotation, 1);
			circle(x, y, z, 1.0F, -rotation, 2);
		}
	}
	
	public static void block(double x, double y, double z, float scale) {
		glPushMatrix();
		
		ITableHelper.block(x, y, z, scale);
		
		// Render
		ITableModel.renderPart(0);
		glPopMatrix();
	}
	
	public static void circle(double x, double y, double z, float scale, float rotate, int part) {
		glPushMatrix();
		
		ITableHelper.Circle(x, y, z, scale, rotate);
		
		// Render
		ITableModel.renderPart(part);
		glPopMatrix();
	}
}
