package ad.Genis231.Refrence;

import ad.Genis231.Blocks.*;
import ad.Genis231.Blocks.Dwarf.Drill;
import ad.Genis231.Blocks.Dwarf.DwarfTable;
import ad.Genis231.Blocks.Dwarf.DwarvenStone;
import ad.Genis231.Blocks.Dwarf.LiquidAle;
import ad.Genis231.Core.MainReg;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ADBlocks{
	public static final Block Dam = new DamBlock(Names.DAM_BLOCK);
	public static final Block FalsePitTrap = new PitTrapBlock(Names.VINE_MAT);
	public static final Block Spike = new Spike(Names.SPIKE);
	public static final Block Drill = new Drill(Names.DRILL);
	public static final Block DwarvenStone = new DwarvenStone(Names.DSTONE,textures.DwarvenStone);
	public static final Block coiningMech = new CoiningMechine(Names.MechCoin,textures.Coin);
	public static final Block AleLiquid = new LiquidAle(MainReg.ale,Names.AleLiquid);
	public static final Block FakeFire = new FakeFire(Names.GFIRE).setCreativeTab(Ref.MainTab);
	public static final Block DTable = new DwarfTable(Names.DTable);

	public static List<Block> getBlocks(){
		List<Block> blocks = new ArrayList<Block>();

		blocks.add(coiningMech);
		blocks.add(Dam);
		blocks.add(Spike);
		blocks.add(FalsePitTrap);
		blocks.add(FakeFire);

		blocks.add(DTable);
		blocks.add(DwarvenStone);

		return blocks;
	}
}
