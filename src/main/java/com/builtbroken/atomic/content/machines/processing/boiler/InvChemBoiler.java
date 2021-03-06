package com.builtbroken.atomic.content.machines.processing.boiler;

import com.builtbroken.atomic.lib.inventory.ItemStackHandlerWrapper;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 9/15/2018.
 */
class InvChemBoiler extends ItemStackHandlerWrapper
{
    private TileEntityChemBoiler tile;

    public InvChemBoiler(TileEntityChemBoiler tile)
    {
        super(tile.getInventory());
        this.tile = tile;
    }

    @Override
    @Nonnull
    public ItemStack extractItem(int slot, int amount, boolean simulate)
    {
        if (slot == TileEntityChemBoiler.SLOT_ITEM_OUTPUT)
        {
            return super.extractItem(slot, amount, simulate);
        }
        return ItemStack.EMPTY;
    }

    @Override
    @Nonnull
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
    {
        if (slot == TileEntityChemBoiler.SLOT_ITEM_INPUT)
        {
            return super.insertItem(slot, stack, simulate);
        }
        return stack;
    }

    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack)
    {
        if (slot == TileEntityChemBoiler.SLOT_FLUID_INPUT)
        {
            return tile.isInputFluid(stack);
        }
        else if (slot == TileEntityChemBoiler.SLOT_HEX_FLUID)
        {
            return tile.isEmptyFluidContainer(stack);
        }
        else if (slot == TileEntityChemBoiler.SLOT_WASTE_FLUID)
        {
            return tile.isEmptyFluidContainer(stack);
        }
        else if (slot == TileEntityChemBoiler.SLOT_ITEM_INPUT)
        {
            return tile.getRecipeList().isComponent(tile, stack);
        }
        return false;
    }
}
