package ad.Genis231.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import ad.Genis231.BaseClass.ADBlock;

public class DwarvenStone extends ADBlock {
	
	public DwarvenStone(String name, String texture) {
		super(Material.rock, name, texture);
		setHardness(10.0f);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float posX, float posY, float posZ) {
		return false;
	}
}
