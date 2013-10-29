package ad.Genis231.Core;

import ad.Genis231.Mobs.RenderStatue;
import ad.Genis231.Mobs.StatueMob;
import ad.Genis231.Render.Models.Blocks.BearTrap;
import ad.Genis231.TileEntitys.SpikeTile;
import ad.Genis231.TileEntitys.SpikeTileRenderer;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(StatueMob.class, new RenderStatue(new BearTrap(), 0.2f));
		
		ClientRegistry.bindTileEntitySpecialRenderer(SpikeTile.class, new SpikeTileRenderer());
		
		Ref.SpikeRender = RenderingRegistry.getNextAvailableRenderId();
		
	}
}
