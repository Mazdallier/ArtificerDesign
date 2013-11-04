package ad.Genis231.Core;

import net.minecraftforge.client.MinecraftForgeClient;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.ItemRendererRender.ItemITable1Renderer;
import ad.Genis231.ItemRendererRender.ItemITable2Renderer;
import ad.Genis231.ItemRendererRender.ItemSpikeRenderer;
import ad.Genis231.TileEntitys.ITable1;
import ad.Genis231.TileEntitys.ITable2;
import ad.Genis231.TileEntitys.ITableRanderer2;
import ad.Genis231.TileEntitys.ITableRenderer1;
import ad.Genis231.TileEntitys.SpikeTile;
import ad.Genis231.TileEntitys.SpikeTileRenderer;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    
    public void registerRenderers() {
        ClientRegistry.bindTileEntitySpecialRenderer(SpikeTile.class, new SpikeTileRenderer());
        
        ClientRegistry.bindTileEntitySpecialRenderer(ITable1.class, new ITableRenderer1());
        ClientRegistry.bindTileEntitySpecialRenderer(ITable2.class, new ITableRanderer2());
        
        Ref.SpikeRender = RenderingRegistry.getNextAvailableRenderId();
        Ref.Table1Render = RenderingRegistry.getNextAvailableRenderId();
        Ref.Table2Render = RenderingRegistry.getNextAvailableRenderId();
        
        MinecraftForgeClient.registerItemRenderer(blocks.Spike.blockID, new ItemSpikeRenderer());
        MinecraftForgeClient.registerItemRenderer(blocks.ItableT1.blockID, new ItemITable1Renderer());
        MinecraftForgeClient.registerItemRenderer(blocks.ItableT2.blockID, new ItemITable2Renderer());
    }
}
