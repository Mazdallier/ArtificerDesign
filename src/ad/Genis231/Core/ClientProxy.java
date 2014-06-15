package ad.Genis231.Core;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import ad.Genis231.Models.mobs.DwarfModel;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Render.Blocks.DTableRenderer;
import ad.Genis231.Render.Blocks.DrillRenderer;
import ad.Genis231.Render.Blocks.PipeRenderer;
import ad.Genis231.Render.Blocks.SpikeRenderer;
import ad.Genis231.Render.Blocks.WMillRenderer;
import ad.Genis231.Render.Items.ItemDTableRenderer;
import ad.Genis231.Render.Items.ItemDrillFrameRenderer;
import ad.Genis231.Render.Items.ItemDrillRenderer;
import ad.Genis231.Render.Items.ItemSpikeRenderer;
import ad.Genis231.Render.Mobs.DwarfRenderer;
import ad.Genis231.TileEntity.DTableTileEntity;
import ad.Genis231.TileEntity.DrillTileEntity;
import ad.Genis231.TileEntity.PipeTileEntity;
import ad.Genis231.TileEntity.SpikeTileEntity;
import ad.Genis231.TileEntity.WMMastTileEntity;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderers() {
		
		for (int i = 0; i < MainReg.dwarfClass.length; i++) {
			RenderingRegistry.registerEntityRenderingHandler(MainReg.dwarfClass[i], new DwarfRenderer(new DwarfModel(), 0.5F, i));
		}
		
		Ref.SpikeRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.DrillRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.DTableRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.WMillRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.PipeRender = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(SpikeTileEntity.class, new SpikeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(DrillTileEntity.class, new DrillRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(DTableTileEntity.class, new DTableRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(WMMastTileEntity.class, new WMillRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(PipeTileEntity.class, new PipeRenderer());
		
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.spike).getItem(), new ItemSpikeRenderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.drillFrame).getItem(), new ItemDrillFrameRenderer());
		MinecraftForgeClient.registerItemRenderer(ADItems.drill, new ItemDrillRenderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.dwarvenTable).getItem(), new ItemDTableRenderer());
	}
}
