package net.utilcraft;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;












//main class
public class mod_utilcraft {
	public static Item PotatoChip;
	
	public void load(FMLInitializationEvent event){
	//add the proper textures
	MinecraftForgeClient.preloadTexture("/UtilCraft/PotatoChip.png");
		
		
		
	//set the in game names
	LanguageRegistry.addName(PotatoChip, "Potato Chip");
	
	
	
	//tell the game to register the recipe
	GameRegistry.addSmelting(PotatoChip.itemID, new ItemStack(PotatoChip,1), 1f);
	
	}
static {
	//declare the item and its attributes
	PotatoChip = (new ItemFood(1000, 1, 4F, true) .setIconIndex(1) .setItemName("Potato Chip"));
}
}