package ad.Genis231.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import ad.Genis231.lib.Ref;

public class ADBlockGui extends ADBlockModel{
		
		 public ADBlockGui(int id, Material material, String name) {
			super(id, material, name);
			this.setCreativeTab(Ref.TAB);
			this.setUnlocalizedName(name);
		}
		
		@Override
		public TileEntity createNewTileEntity(World world) {
			return null;
		}
	

}
