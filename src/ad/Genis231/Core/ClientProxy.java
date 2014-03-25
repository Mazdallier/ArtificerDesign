package ad.Genis231.Core;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import ad.Genis231.Models.mobs.DwarfModel;
import ad.Genis231.Render.Blocks.BtrapRenderer;
import ad.Genis231.Render.Blocks.DrillRenderer;
import ad.Genis231.Render.Blocks.ITableRenderer1;
import ad.Genis231.Render.Blocks.ITableRenderer2;
import ad.Genis231.Render.Blocks.SpikeTileRenderer;
import ad.Genis231.Render.Items.ItemBearTrapRenderer;
import ad.Genis231.Render.Items.ItemDrillRenderer;
import ad.Genis231.Render.Items.ItemITable1Renderer;
import ad.Genis231.Render.Items.ItemITable2Renderer;
import ad.Genis231.Render.Items.ItemSpikeRenderer;
import ad.Genis231.Render.Mobs.dwarfRenderer;
import ad.Genis231.TileEntity.DrillTile;
import ad.Genis231.TileEntity.model.BearTrapTile;
import ad.Genis231.TileEntity.model.ITable1;
import ad.Genis231.TileEntity.model.ITable2;
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
		Ref.TableRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.BTrapRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.DrillRender = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(SpikeTile.class, new SpikeTileRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(ITable1.class, new ITableRenderer1());
		ClientRegistry.bindTileEntitySpecialRenderer(ITable2.class, new ITableRenderer2());
		ClientRegistry.bindTileEntitySpecialRenderer(BearTrapTile.class, new BtrapRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(DrillTile.class, new DrillRenderer());
		
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.Spike).getItem(), new ItemSpikeRenderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.Itable1).getItem(), new ItemITable1Renderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.Itable2).getItem(), new ItemITable2Renderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.BearTrap).getItem(), new ItemBearTrapRenderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlocks.Drill).getItem(), new ItemDrillRenderer());
	}
}
