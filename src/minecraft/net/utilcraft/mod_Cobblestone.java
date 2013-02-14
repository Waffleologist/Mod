package cobble.mod.common;


import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.EnumHelper;
import cobble.common.CommonProxyCobble;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(modid="Waffleologist",name="Cobble",version="0.01")
@NetworkMod(clientSideRequired=true,serverSideRequired=false)

public class mod_Cobblestone {

	//Init Stuff
	public static Block XCobble;
	public static Item CondenseCobble;
	public static Item XcobbleHelm;
	public static Item XcobblePlate;
	public static Item XcobbleLegs;
	public static Item XcobbleBoots;
	
	
	//material
	static EnumArmorMaterial EnumArmorMaterialXcobble = EnumHelper.addArmorMaterial("XCobbleArmor", 35, new int[]{2,4,4,2}, 15);
	
	@SidedProxy(clientSide="cobble.Client.ClientCobbleProxy",serverSide ="cobble.common.CommonProxyCobble")
	public static CommonProxyCobble proxy;
	
	@Init
	public void load(FMLInitializationEvent event){
		
		ItemStack cobbleStack = new ItemStack(Block.cobblestone);
		
		//declare stuff
		Block XCobble=(new XCobble(255,0)).setBlockName("XCobble").setHardness(1F).setResistance(5F);
		Item CondenseCobble =(new CondenseCobble(550)).setItemName("CondenseCobble").setIconIndex(0);
		XcobbleHelm = new ItemXcobbleHelm(508, EnumArmorMaterialXcobble, ModLoader.addArmor("XCobble"),0).setItemName("XCobbleHelm").setIconIndex(1);
		XcobblePlate = new ItemXcobblePlate(509, EnumArmorMaterialXcobble, ModLoader.addArmor("XCobble"),1).setItemName("XCobblePlate").setIconIndex(17);
		XcobbleLegs = new ItemXcobbleLegs(510, EnumArmorMaterialXcobble, ModLoader.addArmor("XCobble"),2).setItemName("XCobbleLegs").setIconIndex(33);
		XcobbleBoots = new ItemXcobbleBoots(511, EnumArmorMaterialXcobble, ModLoader.addArmor("XCobble"),3).setItemName("XCobbleBoots").setIconIndex(49);
		
		
		//register block
		GameRegistry.registerBlock(XCobble);
		GameRegistry.registerItem(CondenseCobble, "CondenseCobble");
		
		
		//register name
		LanguageRegistry.addName(XCobble, "XCobble");
		LanguageRegistry.addName(CondenseCobble, "CondenseCobble");
		LanguageRegistry.addName(XcobbleHelm, "X Cobble Helmet");
		LanguageRegistry.addName(XcobblePlate, "X Cobble Plate");
		LanguageRegistry.addName(XcobbleLegs, "X Cobble Legs");
		LanguageRegistry.addName(XcobbleBoots, "X Cobble Boots");
		
		
	
		//Crafting Recipe
		GameRegistry.addRecipe(new ItemStack(CondenseCobble,1), new Object[]{
			"XXX","XXX","XXX",'X',Block.cobblestone
			});
		GameRegistry.addRecipe(new ItemStack(XcobbleHelm,1), new Object[]{
			"XXX","X X","   ",'X',XCobble
			});
		GameRegistry.addRecipe(new ItemStack(XcobblePlate,1), new Object[]{
			"X X","XXX","XXX",'X',XCobble
			});
		GameRegistry.addRecipe(new ItemStack(XcobbleLegs,1), new Object[]{
			"XXX","X X","X X",'X',XCobble
			});
		GameRegistry.addRecipe(new ItemStack(XcobbleBoots,1), new Object[]{
			"X X","X X","   ",'X',XCobble
			});
		
		
		//smelting recipe Change output to 'stiff cobble for armor'
		GameRegistry.addSmelting(CondenseCobble.itemID,new ItemStack(XCobble,1),0.1f);
		
		
		proxy.registerRenderThings();
	}
}