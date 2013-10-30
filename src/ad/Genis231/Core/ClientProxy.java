package ad.Genis231.Core;

import ad.Genis231.TileEntitys.BTrapRenderer;
import ad.Genis231.TileEntitys.BTrapTile;
import ad.Genis231.TileEntitys.SpikeTile;
import ad.Genis231.TileEntitys.SpikeTileRenderer;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(SpikeTile.class, new SpikeTileRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BTrapTile.class, new BTrapRenderer());
//		
		Ref.SpikeRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.BTrapRender = RenderingRegistry.getNextAvailableRenderId();
	}
}
