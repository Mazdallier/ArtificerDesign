package ad.Genis231.Core;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import ad.Genis231.BaseClasses.ADBlock;
import ad.Genis231.Models.mobs.DwarfModel;
import ad.Genis231.Render.Blocks.BtrapRenderer;
import ad.Genis231.Render.Blocks.ITableRenderer1;
import ad.Genis231.Render.Blocks.ITableRenderer2;
import ad.Genis231.Render.Blocks.SpikeTileRenderer;
import ad.Genis231.Render.Items.ItemBearTrapRenderer;
import ad.Genis231.Render.Items.ItemITable1Renderer;
import ad.Genis231.Render.Items.ItemITable2Renderer;
import ad.Genis231.Render.Items.ItemSpikeRenderer;
import ad.Genis231.Render.Mobs.dwarfRenderer;
import ad.Genis231.TileEntity.BearTrapTile;
import ad.Genis231.TileEntity.ITable1;
import ad.Genis231.TileEntity.ITable2;
import ad.Genis231.TileEntity.SpikeTile;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderers() {
		
		for (int i = 0; i < CreatureReg.dwarfClass.length; i++) {
			RenderingRegistry.registerEntityRenderingHandler(CreatureReg.dwarfClass[i], new dwarfRenderer(new DwarfModel(), 3F, i));
		}
		
		ClientRegistry.bindTileEntitySpecialRenderer(SpikeTile.class, new SpikeTileRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(ITable1.class, new ITableRenderer1());
		ClientRegistry.bindTileEntitySpecialRenderer(ITable2.class, new ITableRenderer2());
		ClientRegistry.bindTileEntitySpecialRenderer(BearTrapTile.class, new BtrapRenderer());
		
		Ref.SpikeRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.TableRender = RenderingRegistry.getNextAvailableRenderId();
		Ref.BTrapRender = RenderingRegistry.getNextAvailableRenderId();
		
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlock.Spike).getItem(), new ItemSpikeRenderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlock.Itable1).getItem(), new ItemITable1Renderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlock.Itable2).getItem(), new ItemITable2Renderer());
		MinecraftForgeClient.registerItemRenderer(new ItemStack(ADBlock.BearTrap).getItem(), new ItemBearTrapRenderer());
	}
}
