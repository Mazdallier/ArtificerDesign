package ad.Genis231.lib;

import net.minecraft.block.Block;
import ad.Genis231.Blocks.BearTrap;
import ad.Genis231.Blocks.CoiningMechine;
import ad.Genis231.Blocks.DamBlock;
import ad.Genis231.Blocks.Drill;
import ad.Genis231.Blocks.DrillPartBlock;
import ad.Genis231.Blocks.DwarvenStone;
import ad.Genis231.Blocks.FakeFire;
import ad.Genis231.Blocks.FalseLoot;
import ad.Genis231.Blocks.ITableBlock;
import ad.Genis231.Blocks.PitTrapBlock;
import ad.Genis231.Blocks.RedGemOre;
import ad.Genis231.Blocks.Spike;
import ad.Genis231.Blocks.driedVine;
import ad.Genis231.Core.MainReg;
import ad.Genis231.Liquids.LiquidAle;

public class ADBlocks {
	public static final Block RedGemOre = new RedGemOre(Names.RED_GEM, BlockTexture.RedGemOre);
	public static final Block Dam = new DamBlock(Names.DAM_BLOCK);
	public static final Block FalseLoot = new FalseLoot(Names.FALSE_LOOT);
	public static final Block FalsePitTrap = new PitTrapBlock(Names.VINE_MAT);
	public static final Block Itable1 = new ITableBlock(Names.IT1);
	public static final Block Itable2 = new ITableBlock(Names.IT2);
	public static final Block Spike = new Spike(Names.SPIKE);
	public static final Block BearTrap = new BearTrap(Names.BTRAP);
	public static final Block Drill = new Drill(Names.DRILL);
	public static final Block DwarvenStone = new DwarvenStone(Names.DSTONE, BlockTexture.DwarvenStone);
	//public static final Block GreenFire = new FakeFire().setBlockName(Names.GFIRE);
	public static final Block DVine = new driedVine(Names.DVINE, BlockTexture.DriedVine);
	public static final Block coingMech = new CoiningMechine(Names.MechCoin, BlockTexture.Coining);
	public static final Block DrillPart = new DrillPartBlock(Names.DrillPart);
	public static final Block AleLiquid = new LiquidAle(MainReg.ale, Names.AleLiquid);
}
