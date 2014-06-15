package ad.Genis231.Core;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import ad.Genis231.Blocks.AirBlock;
import ad.Genis231.Blocks.CoiningMechine;
import ad.Genis231.Blocks.DamBlock;
import ad.Genis231.Blocks.FakeFire;
import ad.Genis231.Blocks.PipeBlock;
import ad.Genis231.Blocks.PitTrapBlock;
import ad.Genis231.Blocks.Spike;
import ad.Genis231.Blocks.WMMast;
import ad.Genis231.Blocks.WindMill;
import ad.Genis231.Blocks.Dwarf.Drill;
import ad.Genis231.Blocks.Dwarf.DwarfTable;
import ad.Genis231.Blocks.Dwarf.DwarvenStone;
import ad.Genis231.Blocks.Dwarf.LiquidAle;
import ad.Genis231.Refrence.Names;
import ad.Genis231.Refrence.Ref;
import ad.Genis231.Refrence.textures;

public class ADBlocks {
	public static final Block dam = new DamBlock(Names.DAM_BLOCK);
	public static final Block falsePitTrap = new PitTrapBlock("PitTrap_Null");
	public static final Block spike = new Spike(Names.SPIKE);
	public static final Block drillFrame = new Drill(Names.DRILLFrame);
	public static final Block dwarvenStone = new DwarvenStone(Names.DSTONE, textures.DwarvenStone);
	public static final Block coiningMech = new CoiningMechine(Names.MechCoin, textures.CoiningMechine);
	public static final Block aleLiquid = new LiquidAle(MainReg.ale, Names.AleLiquid);
	public static final Block fakeFire = new FakeFire(Names.GFIRE).setCreativeTab(Ref.MainTab);
	public static final Block dwarvenTable = new DwarfTable(Names.DwarvenTable);
	public static final Block windmillMast = new WMMast("WindMill_null");
	public static final Block airBlock = new AirBlock("Air_Block");
	public static final Block windmill = new WindMill(Names.WindMill, textures.WindMill);
	public static final Block genericPipe = new PipeBlock("Generic Pipe");
	
	public static List<Block> getBlocks() {
		List<Block> blocks = new ArrayList<Block>();
		
		blocks.add(coiningMech);
		blocks.add(dam);
		blocks.add(spike);
		blocks.add(falsePitTrap);
		blocks.add(fakeFire);
		blocks.add(windmillMast);
		blocks.add(airBlock);
		blocks.add(dwarvenTable);
		blocks.add(dwarvenStone);
		blocks.add(windmill);
		blocks.add(genericPipe);
		
		return blocks;
	}
}
