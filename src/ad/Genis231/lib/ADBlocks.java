package ad.Genis231.lib;

import net.minecraft.block.Block;
import ad.Genis231.Blocks.CoiningMechine;
import ad.Genis231.Blocks.DamBlock;
import ad.Genis231.Blocks.Drill;
import ad.Genis231.Blocks.DwarfTable;
import ad.Genis231.Blocks.DwarvenStone;
import ad.Genis231.Blocks.FakeFire;
import ad.Genis231.Blocks.LiquidAle;
import ad.Genis231.Blocks.PitTrapBlock;
import ad.Genis231.Blocks.Spike;
import ad.Genis231.Core.MainReg;

public class ADBlocks {
	public static final Block Dam = new DamBlock(Names.DAM_BLOCK);
	public static final Block FalsePitTrap = new PitTrapBlock(Names.VINE_MAT);
	public static final Block Spike = new Spike(Names.SPIKE);
	public static final Block Drill = new Drill(Names.DRILL);
	public static final Block DwarvenStone = new DwarvenStone(Names.DSTONE, BlockTexture.DwarvenStone);
	public static final Block coiningMech = new CoiningMechine(Names.MechCoin, ItemTexture.Coin);
	public static final Block AleLiquid = new LiquidAle(MainReg.ale, Names.AleLiquid);
	public static final Block FakeFire = new FakeFire(Names.GFIRE).setCreativeTab(Ref.MainTab);
	public static final Block DTable = new DwarfTable(Names.DTable);
}
