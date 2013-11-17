package ad.Genis231.Core;

import java.util.Random;

import net.minecraftforge.client.MinecraftForgeClient;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.Render.Blocks.ITableRenderer1;
import ad.Genis231.Render.Blocks.ITableRenderer2;
import ad.Genis231.Render.Blocks.SpikeTileRenderer;
import ad.Genis231.Render.Items.ItemITable1Renderer;
import ad.Genis231.Render.Items.ItemITable2Renderer;
import ad.Genis231.Render.Items.ItemSpikeRenderer;
import ad.Genis231.Render.Mobs.dwarfRenderer;
import ad.Genis231.Render.Models.mobs.DwarfModel;
import ad.Genis231.Render.TileEntity.ITable1;
import ad.Genis231.Render.TileEntity.ITable2;
import ad.Genis231.Render.TileEntity.SpikeTile;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    
    public void registerRenderers() {
        Random rand = new Random();
        
        for (int i = 0; i < modReg.dwarfClass.length; i++) {
            RenderingRegistry.registerEntityRenderingHandler(modReg.dwarfClass[i], new dwarfRenderer(new DwarfModel(), 3F, i));
        }
        
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
