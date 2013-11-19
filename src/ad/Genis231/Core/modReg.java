package ad.Genis231.Core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import ad.Genis231.Blocks.blocks;
import ad.Genis231.Generation.BDiaGen;
import ad.Genis231.Items.items;
import ad.Genis231.Items.pit_trap;
import ad.Genis231.Mobs.dwarfMob;
import ad.Genis231.Mobs.savageDwarf;
import ad.Genis231.Mobs.traderDwarf;
import ad.Genis231.Mobs.warriorDwarf;
import ad.Genis231.lib.ADLog;
import ad.Genis231.lib.Ref;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class modReg {
    static int baseEntityID = 300;
    
    public static void blockReg() {
        GameRegistry.registerBlock(blocks.BDiamond_ore, "BDOre");
        GameRegistry.registerBlock(blocks.FPTrap, "null_Block");
        GameRegistry.registerBlock(blocks.Dam, "dam_block");
        GameRegistry.registerBlock(blocks.FalseLoot, "FalseLoot");
        GameRegistry.registerBlock(blocks.ItableT1, "Itable1");
        GameRegistry.registerBlock(blocks.ItableT2, "Itable2");
        GameRegistry.registerBlock(blocks.GlowDirt, "GlowDirt");
        GameRegistry.registerBlock(blocks.Spike, "SpikeTrap");
    }
    
    public static void itemReg() {
        GameRegistry.registerItem(items.ODust, "ORangeDust");
        GameRegistry.registerItem(items.PTrap, "VineMat");
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
    
    public static Class[] dwarfClass = { savageDwarf.class, warriorDwarf.class, traderDwarf.class };
    public static String[] dwarfNames = { "Savage", "Warrior", "Trader" };
    
    public static void mobs() {
        // registers the mod, args: MobClass.class, max hoard, min spawned, max spawned, MobType/SpawnArea.......
        for (int i = 0; i < dwarfClass.length; i++) {
            EntityRegistry.registerModEntity(dwarfClass[i], dwarfNames[i], i, Core.instance, 80, 3, true);
            EntityRegistry.addSpawn(dwarfClass[i], 20, 20, 20, EnumCreatureType.creature, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge);
            
            // registers egg, args: MobClass.class, hex-Main, hex-Spots
            registerNewEgg(dwarfClass[i], UniqueId(), 0xFF0000, 0xBBFF00);
            ADLog.logger.info("~~~~~~~~~~Registers Entity " + dwarfNames[i] + " ~~~~~~~~~~");
            // registers name on kill screan
            LanguageRegistry.instance().addStringLocalization("entity.Artificer." + dwarfNames[i] + ".name", dwarfNames[i] + " Dwarf");
        }
    }
    
    public static int UniqueId() {
        do {
            baseEntityID++;
        } while (EntityList.getStringFromID(baseEntityID) != null);
        
        System.err.println(baseEntityID);
        return baseEntityID;
    }
    
    public static void registerNewEgg(Class<? extends Entity> entity, int id, int primaryColor, int secondaryColor) {
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }
}
