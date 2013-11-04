package ad.Genis231.Core;

import net.minecraftforge.client.MinecraftForgeClient;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.ItemRendererRender.ItemSpikeRenderer;
import ad.Genis231.TileEntitys.SpikeTile;
import ad.Genis231.TileEntitys.SpikeTileRenderer;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(SpikeTile.class, new SpikeTileRenderer());
		
		Ref.SpikeRender = RenderingRegistry.getNextAvailableRenderId();
		
		MinecraftForgeClient.registerItemRenderer(blocks.Spike.blockID, new ItemSpikeRenderer());
	}
}
