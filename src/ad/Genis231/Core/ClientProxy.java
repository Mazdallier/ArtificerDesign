package ad.Genis231.Core;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import ad.Genis231.Models.mobs.DwarfModel;
import ad.Genis231.Render.Blocks.DrillRenderer;
import ad.Genis231.Render.Blocks.GeneratorRenderer;
import ad.Genis231.Render.Blocks.SpikeTileRenderer;
import ad.Genis231.Render.Items.ItemDrillRenderer;
import ad.Genis231.Render.Items.ItemGenRenderer;
import ad.Genis231.Render.Items.ItemSpikeRenderer;
import ad.Genis231.Render.Mobs.dwarfRenderer;
import ad.Genis231.TileEntity.DrillTile;
import ad.Genis231.TileEntity.GeneratorTile;
import ad.Genis231.TileEntity.model.SpikeTile;
import ad.Genis231.lib.ADBlocks;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderers() {
		
		for (int i = 0; i < MainReg.dwarfClass.length; i++) {
			RenderingRegistry.registerEntityRenderingHandler(MainReg.dwarfClass[i], new dwarfRenderer(new DwarfModel(), 5F, i));
		}
		
		Ref.SpikeRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.DrillRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.GeneratorRender = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(SpikeTile.class, new SpikeTileRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(DrillTile.class, new DrillRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(GeneratorTile.class, new GeneratorRenderer());
		
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.Spike).getItem(), new ItemSpikeRenderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.Drill).getItem(), new ItemDrillRenderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.Generator).getItem(), new ItemGenRenderer());
	}
}
