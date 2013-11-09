package ad.Genis231.Core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.Generation.BDiaGen;
import ad.Genis231.Items.items;
import ad.Genis231.Items.pit_trap;
import ad.Genis231.Mobs.StatueMob;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class modReg {
    static int baseEntityID = 300;
    
    public modReg(int i) {
        switch (i) {
            case 1: // pre-init
                blockReg();
                itemReg();
                recipeGReg();
                Worlds();
            case 2: // init
                blockLang();
                itemLang();
                Modifiers();
                mobs();
            case 3: // post-init
        }
        
    }
    
    public static void blockReg() {
        GameRegistry.registerBlock(blocks.BDiamond_ore, "BDOre");
        GameRegistry.registerBlock(blocks.FPTrap, "null_Block");
        GameRegistry.registerBlock(blocks.Dam, "dam_block");
        GameRegistry.registerBlock(blocks.FalseLoot, "FalseLoot");
        GameRegistry.registerBlock(blocks.ItableT1, "Itable1");
        GameRegistry.registerBlock(blocks.ItableT2, "Itable2");
        GameRegistry.registerBlock(blocks.GlowDirt, "GlowDirt");
        GameRegistry.registerBlock(blocks.Spike, "SpikeTrap");
        GameRegistry.registerBlock(blocks.portal, "PortalBlock");
    }
    
    public static void itemReg() {
        GameRegistry.registerItem(items.ODust, "ORangeDust");
        GameRegistry.registerItem(items.PTrap, "PTrap");
        GameRegistry.registerItem(items.DBdirty, "BDdirty");
        GameRegistry.registerItem(items.BDPure, "BDPure");
        GameRegistry.registerItem(items.GBowl, "GoldBowl");
        GameRegistry.registerItem(items.VBlood, "VampireBlood");
    }
    
    public static void recipeGReg() {
        final ItemStack ODStack = new ItemStack(items.ODust, 1);
        final ItemStack RedstoneStack = new ItemStack(Item.redstone, 1);
        final ItemStack GlowstoneStack = new ItemStack(Item.glowstone, 1);
        
        GameRegistry.addShapelessRecipe(ODStack, GlowstoneStack, RedstoneStack, RedstoneStack);
        GameRegistry.addShapedRecipe(new ItemStack(items.GBowl), "X X", " X ", 'X', new ItemStack(Item.ingotGold, 1));
        
    }
    
    public static void blockLang() {
        LanguageRegistry.addName(blocks.BDiamond_ore, "Dirty Blood Gem Ore");
        LanguageRegistry.addName(blocks.Dam, "Dam (WIP)");
        LanguageRegistry.addName(blocks.FalseLoot, "False Loot");
        LanguageRegistry.addName(blocks.ItableT1, "Imbueing Table teir1");
        LanguageRegistry.addName(blocks.ItableT2, "Imbueing Table teir2");
        LanguageRegistry.addName(blocks.GlowDirt, "Glow Dirt");
        LanguageRegistry.addName(blocks.Spike, "Spike Trap");
        LanguageRegistry.addName(blocks.portal, "PortalBlock");
    }
    
    public static void itemLang() {
        LanguageRegistry.addName(items.ODust, "Orange Dust");
        LanguageRegistry.addName(items.GBowl, "Gold Bowl");
        LanguageRegistry.addName(items.VBlood, "Vampire Blood");
        LanguageRegistry.addName(items.BDPure, "Blood Infussed Diamond");
        LanguageRegistry.addName(items.DBdirty, "Impure Red Diamond");
        
        for (int i = 0; i < pit_trap.UnlocalizedArray.length; i++)
            LanguageRegistry.addName(items.PTrap, pit_trap.UnlocalizedArray[new ItemStack(items.PTrap, 1, i).getItemDamage()]);
    }
    
    public static void Worlds() {
        GameRegistry.registerWorldGenerator(new BDiaGen());
    }
    
    public static void Modifiers() {
        MinecraftForge.setBlockHarvestLevel(blocks.BDiamond_ore, "pickaxe", 2);
        
    }
    
    public static void mobs() {
        // registers the mod, args: MobClass.class, max hoard, min spawned, max spawned, MobType/SpawnArea.......
        EntityRegistry.addSpawn(StatueMob.class, 20, 3, 10, EnumCreatureType.creature);
        
        // registers egg, args: MobClass.class, hex-Main, hex-Spots
        registerEntityEgg(StatueMob.class, 0x7A65CF, 0x87CF65);
        
        // registers name on kill screan
        LanguageRegistry.instance().addStringLocalization("entity.Artificer.StatueThing.name", "StatueThing (WIP)");
    }
    
    public static int getUniqueEntitityId() {
        do {
            baseEntityID++;
        } while (EntityList.getStringFromID(baseEntityID) != null);
        
        return baseEntityID;
    }
    
    public static void registerEntityEgg(Class<? extends Entity> entity, int Main, int Spots) {
        int id = getUniqueEntitityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, Main, Spots));
    }
}
