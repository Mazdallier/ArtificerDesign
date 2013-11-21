package ad.Genis231.Blocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import ad.Genis231.lib.ADLog;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.blockIDs;

public class blocks {
    public static final Block BDiamond_ore = new BloodDiamond_Ore(blockIDs.BDOre).setUnlocalizedName("BloodOre").setCreativeTab(Ref.TAB);
    public static final Block Dam = new dam_block(blockIDs.DamBlock).setUnlocalizedName("DamBlock").setCreativeTab(Ref.TAB);
    public static final Block FalseLoot = new false_loot(blockIDs.False_Loot).setUnlocalizedName("FalseLootBlocks").setCreativeTab(Ref.TAB);
    public static final Block FPTrap = new PTBlock(blockIDs.FALSE_PIT_TRAP).setUnlocalizedName("Null_block");
    public static final Block ItableT1 = new ITableBlock(blockIDs.ITableT1).setCreativeTab(Ref.TAB).setUnlocalizedName("ITable1");
    public static final Block ItableT2 = new ITableBlock(blockIDs.ITableT2).setCreativeTab(Ref.TAB).setUnlocalizedName("ITable2");
    public static final Block GlowDirt = new GlowDirt(blockIDs.GDirt).setCreativeTab(Ref.TAB).setUnlocalizedName("GlowDirt");
    public static final Block Spike = new SpikeTrap(blockIDs.Spike).setCreativeTab(Ref.TAB).setUnlocalizedName("Spike");
    
    
}
