package ad.Genis231.Generation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import ad.Genis231.lib.Ref;

public class NewWorldProvider extends WorldProvider {
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.desert, 0.8F, 0.1F);
		this.dimensionId = Ref.PortalNumber;
	}
	
	public IChunkProvider createChunkGenerator() {
		return new chunkProvider(worldObj, worldObj.getSeed(), true, null);
	}
	
	/**
	 * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
	 */
	public float calculateCelestialAngle(long par1, float par3) {
		return 0.0F;
	}
	
	@SideOnly(Side.CLIENT)/** Returns array with sunrise/sunset color*/
	public float[] calcSunriseSunsetColors(float par1, float par2) {
		return null;
	}
	
	@SideOnly(Side.CLIENT) public boolean isSkyColored() {
		return true;
	}
	
	/**True if the player can respawn in this dimension (true = overworld, false = nether).*/
	public boolean canRespawnHere() {
		return true;
	}
	
	@SideOnly(Side.CLIENT)/**the y level at which clouds are rendered.*/
	public float getCloudHeight() {
		return 80.0F;
	}
	
	/**
	 * Will check if the x, z position specified is alright to be set as the map spawn point
	 */
	public boolean canCoordinateBeSpawn(int par1, int par2) {
		int k = this.worldObj.getFirstUncoveredBlock(par1, par2);
		return k == 0 ? false : Block.blocksList[k].blockMaterial.blocksMovement();
	}
	
	/*
	 * Gets the hard-coded portal location to use when entering this dimension.
	 */
	public ChunkCoordinates getEntrancePortalLocation() {
		return new ChunkCoordinates(0, 500, 0);
	}
	
	public int getAverageGroundLevel(){
		return 50;
	}
	
	public String getDimensionName() {
		return "Roarz";
	}
}
