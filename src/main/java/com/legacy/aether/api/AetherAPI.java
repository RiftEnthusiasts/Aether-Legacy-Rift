package com.legacy.aether.api;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;
import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;

import com.legacy.aether.api.accessories.Accessory;
import com.legacy.aether.api.enchantment.Enchantment;
import com.legacy.aether.api.enchantment.EnchantmentFuel;
import com.legacy.aether.api.freezable.Freezable;
import com.legacy.aether.api.freezable.FreezableFuel;
import com.legacy.aether.api.moa.MoaType;

public class AetherAPI
{

	private static final RegistryNamespacedDefaultedByKey<Accessory> ACCESSORY_REGISTRY = new RegistryNamespacedDefaultedByKey<Accessory>(new ResourceLocation("empty"));

	private static final RegistryNamespacedDefaultedByKey<Enchantment> ENCHANTMENT_REGISTRY = new RegistryNamespacedDefaultedByKey<Enchantment>(new ResourceLocation("empty"));

	private static final RegistryNamespacedDefaultedByKey<Freezable> FREEZABLE_REGISTRY = new RegistryNamespacedDefaultedByKey<Freezable>(new ResourceLocation("empty"));

	private static final RegistryNamespacedDefaultedByKey<EnchantmentFuel> ENCHANTMENT_FUEL_REGISTRY = new RegistryNamespacedDefaultedByKey<EnchantmentFuel>(new ResourceLocation("empty"));

	private static final RegistryNamespacedDefaultedByKey<FreezableFuel> FREEZABLE_FUEL_REGISTRY = new RegistryNamespacedDefaultedByKey<FreezableFuel>(new ResourceLocation("empty"));

	private static final RegistryNamespacedDefaultedByKey<MoaType> MOA_REGISTRY = new RegistryNamespacedDefaultedByKey<MoaType>(new ResourceLocation("empty"));

	private static int moaListSize;

	private static final AetherAPI INSTANCE = new AetherAPI();

	public AetherAPI()
	{

	}

	public void register(ResourceLocation registryName, MoaType moa)
	{
		moa.setRegistryName(registryName);

		MOA_REGISTRY.put(registryName, moa);
		++moaListSize;
	}

	public void register(Accessory accessory)
	{
		ACCESSORY_REGISTRY.put(IRegistry.ITEM.getKey(accessory.getItem()), accessory);
	}

	public void register(Freezable freezable)
	{
		FREEZABLE_REGISTRY.put(IRegistry.ITEM.getKey(freezable.getInput()), freezable);
	}

	public void register(FreezableFuel fuel)
	{
		FREEZABLE_FUEL_REGISTRY.put(IRegistry.ITEM.getKey(fuel.getFuel()), fuel);
	}

	public void register(Enchantment enchantment)
	{
		ENCHANTMENT_REGISTRY.put(IRegistry.ITEM.getKey(enchantment.getInput()), enchantment);
	}

	public void register(EnchantmentFuel fuel)
	{
		ENCHANTMENT_FUEL_REGISTRY.put(IRegistry.ITEM.getKey(fuel.getFuel()), fuel);
	}

	public Accessory getAccessory(ItemStack stack)
	{
		return ACCESSORY_REGISTRY.get(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public boolean isAccessory(ItemStack stack)
	{
		return ACCESSORY_REGISTRY.containsKey(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public Freezable getFreezable(ItemStack stack)
	{
		return FREEZABLE_REGISTRY.get(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public boolean isFreezable(ItemStack stack)
	{
		return FREEZABLE_REGISTRY.containsKey(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public FreezableFuel getFreezableFuel(ItemStack stack) 
	{
		return FREEZABLE_FUEL_REGISTRY.get(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public boolean isFreezerFuel(ItemStack stack)
	{
		return FREEZABLE_FUEL_REGISTRY.containsKey(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public Enchantment getEnchantment(ItemStack stack)
	{
		return ENCHANTMENT_REGISTRY.get(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public boolean isEnchantable(ItemStack stack)
	{
		return ENCHANTMENT_REGISTRY.containsKey(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public EnchantmentFuel getEnchantmentFuel(ItemStack stack) 
	{
		return ENCHANTMENT_FUEL_REGISTRY.get(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public boolean isEnchantmentFuel(ItemStack stack)
	{
		return ENCHANTMENT_FUEL_REGISTRY.containsKey(IRegistry.ITEM.getKey(stack.getItem()));
	}

	public MoaType getMoa(Random random)
	{
		return MOA_REGISTRY.getRandom(random);
	}

	public MoaType getMoa(ResourceLocation registryName)
	{
		return MOA_REGISTRY.get(registryName);
	}

	public MoaType getMoa(int id)
	{
		return MOA_REGISTRY.get(id);
	}

	public int getMoaId(MoaType moa)
	{
		return MOA_REGISTRY.getId(moa);
	}

	public int getMoaRegistrySize()
	{
		return moaListSize;
	}

	public static AetherAPI instance()
	{
		return INSTANCE;
	}

}