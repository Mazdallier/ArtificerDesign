package ad.Genis231.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.EnumMobType;
import ad.Genis231.lib.Ref;
import ad.Genis231.lib.blockIDs;

public class blocks {
    public static final Block BDiamond_ore =  new BloodDiamond_Ore(blockIDs.BDOre)     .setCreativeTab(Ref.TAB).setUnlocalizedName("BloodOre");
    public static final Block Dam =           new dam_block(blockIDs.DamBlock)         .setCreativeTab(Ref.TAB).setUnlocalizedName("DamBlock");
    public static final Block FalseLoot =     new false_loot(blockIDs.False_Loot)      .setCreativeTab(Ref.TAB).setUnlocalizedName("FalseLootBlocks");
    public static final Block FPTrap =        new PTBlock(blockIDs.FALSE_PIT_TRAP)                             .setUnlocalizedName("Null_block");
    public static final Block ItableT1 =      new ITableBlock(blockIDs.ITableT1)       .setCreativeTab(Ref.TAB).setUnlocalizedName("ITable1");
    public static final Block ItableT2 =      new ITableBlock(blockIDs.ITableT2)       .setCreativeTab(Ref.TAB).setUnlocalizedName("ITable2");
    public static final Block Spike =         new SpikeTrap(blockIDs.Spike)            .setCreativeTab(Ref.TAB).setUnlocalizedName("Spike"); 
    public static final Block BTrap =         new BTrap(blockIDs.BearTrap)             .setCreativeTab(Ref.TAB).setUnlocalizedName("BTrap");
    public static final Block Drill =         new Drill(blockIDs.Drill)                .setCreativeTab(Ref.TAB).setUnlocalizedName("Drill_MB");
    public static final Block DwarvenStone =  new DwarvenStone(blockIDs.DStone)        .setCreativeTab(Ref.TAB).setUnlocalizedName("DwarvenStone");
}
