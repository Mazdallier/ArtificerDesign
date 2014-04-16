package ad.Genis231.eventHandler;

import ad.Genis231.Player.PlayerData;
import ad.Genis231.Player.PlayerRace;
import ad.Genis231.Refrence.textures;
import ad.Genis231.Resources.ADSkillBook;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import java.awt.*;
import java.io.File;

@SideOnly(Side.CLIENT)
public class ResearchPointsOverlay extends Gui{
	protected Minecraft mc;
	FontRenderer font;

	public ResearchPointsOverlay(Minecraft mc){
		super();
		this.mc = mc;
		this.font = mc.fontRenderer;
	}

	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event){
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE || mc.gameSettings.showDebugInfo){
			return;
		}

		PlayerData props = PlayerData.get(mc.thePlayer);

		if(props == null){
			return;
		}

		drawStatus(props,props.getRace());
		//applyAtribbute(props.getRace(), mc.thePlayer);
	}

	public void drawStatus(PlayerData data,PlayerRace race){
		this.mc.getTextureManager().bindTexture(textures.ResearchPoints);
		this.drawTexturedModalRect(20,20,0,10,200 - 20,10);
		this.drawTexturedModalRect(20,20,0,0,data.getPoints() % 200,10);
		font.drawStringWithShadow("Level: " + data.getPoints() / 200 + "      Total Points: " + data.getPoints(),20,10,Color.GREEN.getRGB());

		font.drawString("Current Class: " + race.getName(),20,30,Color.RED.getRGB());

		ItemStack stack = this.mc.thePlayer.inventory.getStackInSlot(this.mc.thePlayer.inventory.currentItem);
		Item item;

		if(stack != null){
			item = stack.getItem();
			if(item instanceof ADSkillBook){
				if(!new File("mods/desc").exists()){
					font.drawStringWithShadow("add a folder called 'desc' to ur mods folder",20,45,0xFF63FF);
					font.drawStringWithShadow("and fill it with *.artificer files that are in dropbox",20,55,0xFF63FF);

				}else{

					font.drawStringWithShadow("To update the file just save the file!",20,45,0xFF63FF);
					font.drawStringWithShadow("Then just click anywhere",20,55,0xFF63FF);
				}
			}
		}
	}

	void applyAtribbute(PlayerRace race,EntityPlayer player){
		player.sendPlayerAbilities();

		for(int size = 0; size < 65; size++){
			for(int meta = 0; meta < 16; meta++){
				this.mc.thePlayer.curePotionEffects(new ItemStack(Items.milk_bucket,size,meta));
			}
		}

		if(race != PlayerRace.HUMAN){
			this.mc.thePlayer.addPotionEffect(new PotionEffect(race.getPot1(),200,race.getLevel()));
			this.mc.thePlayer.addPotionEffect(new PotionEffect(race.getPot2(),200,race.getLevel()));
		}

	}
}
