package ad.Genis231.Core;

import net.minecraftforge.client.MinecraftForgeClient;
import ad.Genis231.Block.Renderer.ITableRenderer1;
import ad.Genis231.Block.Renderer.ITableRenderer2;
import ad.Genis231.Block.Renderer.SpikeTileRenderer;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.ItemRendererRender.ItemITable1Renderer;
import ad.Genis231.ItemRendererRender.ItemITable2Renderer;
import ad.Genis231.ItemRendererRender.ItemSpikeRenderer;
import ad.Genis231.Mobs.dwarfMob;
import ad.Genis231.Mobs.dwarfRenderer;
import ad.Genis231.Render.Models.mobs.DwarfModel;
import ad.Genis231.TileEntity.Renderer.ITable1;
import ad.Genis231.TileEntity.Renderer.ITable2;
import ad.Genis231.TileEntity.Renderer.SpikeTile;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(dwarfMob.class, new dwarfRenderer(new DwarfModel(), 3F));
        
        ClientRegistry.bindTileEntitySpecialRenderer(SpikeTile.class, new SpikeTileRenderer());
        
        ClientRegistry.bindTileEntitySpecialRenderer(ITable1.class, new ITableRenderer1());
        ClientRegistry.bindTileEntitySpecialRenderer(ITable2.class, new ITableRenderer2());
        
        Ref.SpikeRender = RenderingRegistry.getNextAvailableRenderId();
        Ref.Table1Render = RenderingRegistry.getNextAvailableRenderId();
        Ref.Table2Render = RenderingRegistry.getNextAvailableRenderId();
        
        MinecraftForgeClient.registerItemRenderer(blocks.Spike.blockID, new ItemSpikeRenderer());
        MinecraftForgeClient.registerItemRenderer(blocks.ItableT1.blockID, new ItemITable1Renderer());
        MinecraftForgeClient.registerItemRenderer(blocks.ItableT2.blockID, new ItemITable2Renderer());
    }
}
