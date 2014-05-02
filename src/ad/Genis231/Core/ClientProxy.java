package ad.Genis231.Core;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import ad.Genis231.Models.mobs.DwarfModel;
import ad.Genis231.Refrence.ADBlocks;
import ad.Genis231.Refrence.ADItems;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Render.Blocks.DTableRenderer;
import ad.Genis231.Render.Blocks.DrillRenderer;
import ad.Genis231.Render.Blocks.SpikeRenderer;
import ad.Genis231.Render.Items.ItemDTableRenderer;
import ad.Genis231.Render.Items.ItemDrillFrameRenderer;
import ad.Genis231.Render.Items.ItemDrillRenderer;
import ad.Genis231.Render.Items.ItemSpikeRenderer;
import ad.Genis231.Render.Mobs.dwarfRenderer;
import ad.Genis231.TileEntity.DTableTile;
import ad.Genis231.TileEntity.DrillTile;
import ad.Genis231.TileEntity.SpikeTile;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderers() {
		
		for (int i = 0; i < MainReg.dwarfClass.length; i++) {
			RenderingRegistry.registerEntityRenderingHandler(MainReg.dwarfClass[i], new dwarfRenderer(new DwarfModel(), 5F, i));
		}
		
		Ref.SpikeRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.DrillRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.DTableRender = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(SpikeTile.class, new SpikeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(DrillTile.class, new DrillRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(DTableTile.class, new DTableRenderer());
		
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.Spike).getItem(), new ItemSpikeRenderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.DrillFrame).getItem(), new ItemDrillFrameRenderer());
		MinecraftForgeClient.registerItemRenderer(ADItems.Drill, new ItemDrillRenderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.DTable).getItem(), new ItemDTableRenderer());
	}
}
