package ad.Genis231.Generation;

import ad.Genis231.BaseClasses.ADBlock;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class BDiaGen implements IWorldGenerator {
	
	@Override public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
			case 0:
				addOreSpawn(world, random, chunkX * 16, chunkZ * 16, 16, 16, 1, 30);
		}
		
	}
	
	public void addOreSpawn(World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int minY, int maxY) {
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
			int rand = random.nextInt(4);
			
			for (int q = 1; q < dist; q++) {
				for (int w = 0; w < dist; w++) {
					for (int e = 0; e < dist; e++) {
						if ((world.getBlock(posX + q, posY + e, posZ + w) == Blocks.iron_ore && world.getBlock(posX, posY, posZ) != Blocks.iron_ore) || posY > 200) {
							if (rand > 1) {
								vein(world, posX, posY, posZ, rand, random);
							} else {
								world.setBlock(posX, posY, posZ, ADBlock.RedGemOre);
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
			
			if (world.getBlock(posX + a, posY + s, posZ + d) != Blocks.iron_ore && i <= rand) {
				world.setBlock(posX + a, posY + s, posZ + d, ADBlock.RedGemOre);
				i++;
			}
			
		}
	}
}
