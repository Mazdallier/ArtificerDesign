package ad.Genis231.Generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import ad.Genis231.Blocks.blocks;
import cpw.mods.fml.common.IWorldGenerator;

public class BDiaGen implements IWorldGenerator {
	
	@Override public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId == 0) {
			this.addOreSpawn(world, random, chunkX * 16, chunkZ * 16, 16, 16, 1, 30);
		}
		
	}
	
	/** Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
	 * 
	 * @param The Block to spawn
	 * @param The World to spawn in
	 * @param A Random object for retrieving random positions within the world to spawn the Block
	 * @param An int for passing the X-Coordinate for the Generation method
	 * @param An int for passing the Z-Coordinate for the Generation method
	 * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
	 * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
	 * @param An int for setting the maximum size of a vein
	 * @param An int for the Number of chances available for the Block to spawn per-chunk
	 * @param An int for the minimum Y-Coordinate height at which this block may spawn
	 * @param An int for the maximum Y-Coordinate height at which this block may spawn **/
	
	public void addOreSpawn(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int minY, int maxY) {
		int maxPossY = minY + (maxY - 1);
		assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
		assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
		assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
		assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
		assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";
		
		int diffBtwnMinMaxY = maxY - minY;
		for (int x = 0; x < 16; x++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffBtwnMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
			int dist = 3;
			int roar = 1;
			int rand = random.nextInt(4);
			
			for (int q = 1; q < dist; q++) {
				for (int w = 0; w < dist; w++) {
					for (int e = 0; e < dist; e++) {
						if ((world.getBlockId(posX + q, posY + e, posZ + w) == Block.oreIron.blockID && world.getBlockId(posX, posY, posZ) != Block.oreIron.blockID) || posY > 200) {
							if (rand > 1) {
								vein(world, posX, posY, posZ, rand, random);
							} else {
								world.setBlock(posX, posY, posZ, blocks.BDiamond_ore.blockID);
							}
							return;
						}
					}
				}
			}
		}
	}
	
	void vein(World world, int posX, int posY, int posZ, int rand, Random random) {
		int i = 1;
		int a, s, d;
		while (i <= rand) {
			a = random.nextInt(2);
			s = random.nextInt(2);
			d = random.nextInt(2);
			
			if (world.getBlockId(posX + a, posY + s, posZ + d) != Block.oreIron.blockID && i <= rand) {
				world.setBlock(posX + a, posY + s, posZ + d, blocks.BDiamond_ore.blockID);
				i++;
			}
			
		}
	}
}
