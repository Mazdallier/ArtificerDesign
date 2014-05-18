package ad.Genis231.Refrence;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import ad.Genis231.Blocks.AirBlock;
import ad.Genis231.Blocks.CoiningMechine;
import ad.Genis231.Blocks.DamBlock;
import ad.Genis231.Blocks.FakeFire;
import ad.Genis231.Blocks.PitTrapBlock;
import ad.Genis231.Blocks.Spike;
import ad.Genis231.Blocks.WMMast;
import ad.Genis231.Blocks.WindMill;
import ad.Genis231.Blocks.Dwarf.Drill;
import ad.Genis231.Blocks.Dwarf.DwarfTable;
import ad.Genis231.Blocks.Dwarf.DwarvenStone;
import ad.Genis231.Blocks.Dwarf.LiquidAle;
import ad.Genis231.Core.MainReg;

public class ADBlocks {
	public static final Block Dam = new DamBlock(Names.DAM_BLOCK);
	public static final Block FalsePitTrap = new PitTrapBlock("PitTrap_Null");
	public static final Block Spike = new Spike(Names.SPIKE);
	public static final Block DrillFrame = new Drill(Names.DRILLFrame);
	public static final Block DwarvenStone = new DwarvenStone(Names.DSTONE, textures.DwarvenStone);
	public static final Block coiningMech = new CoiningMechine(Names.MechCoin, textures.Coin);
	public static final Block AleLiquid = new LiquidAle(MainReg.ale, Names.AleLiquid);
	public static final Block FakeFire = new FakeFire(Names.GFIRE).setCreativeTab(Ref.MainTab);
	public static final Block DTable = new DwarfTable(Names.DTable);
	public static final Block WMMast = new WMMast("WindMill_null");
	public static final Block ADAir = new AirBlock("Air_Block");
	public static final Block Windmill = new WindMill("Windmill");
	
	public static List<Block> getBlocks() {
		List<Block> blocks = new ArrayList<Block>();
		
		blocks.add(coiningMech);
		blocks.add(Dam);
		blocks.add(Spike);
		blocks.add(FalsePitTrap);
		blocks.add(FakeFire);
		blocks.add(WMMast);
		blocks.add(ADAir);
		blocks.add(DTable);
		blocks.add(DwarvenStone);
		blocks.add(Windmill);
		
		return blocks;
	}
}
