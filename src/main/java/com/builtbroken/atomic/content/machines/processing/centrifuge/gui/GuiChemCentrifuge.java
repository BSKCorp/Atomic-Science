package com.builtbroken.atomic.content.machines.processing.centrifuge.gui;

import com.builtbroken.atomic.AtomicScience;
import com.builtbroken.atomic.content.machines.processing.centrifuge.TileEntityChemCentrifuge;
import com.builtbroken.atomic.lib.LanguageUtility;
import com.builtbroken.atomic.lib.gui.GuiContainerBase;
import com.builtbroken.atomic.lib.gui.tip.ToolTipTank;
import net.minecraft.entity.player.EntityPlayer;

import java.awt.*;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 5/23/2018.
 */
public class GuiChemCentrifuge extends GuiContainerBase<TileEntityChemCentrifuge>
{
    public final Rectangle AREA_BLUE_TANK = new Rectangle(8, 20, meterWidth, meterHeight);
    public final Rectangle AREA_GREEN_TANK = new Rectangle(155, 20, meterWidth, meterHeight);

    public GuiChemCentrifuge(EntityPlayer player, TileEntityChemCentrifuge host)
    {
        super(new ContainerChemCentrifuge(player, host), host);
    }

    @Override
    public void initGui()
    {
        super.initGui();
        addToolTip(new ToolTipTank(AREA_BLUE_TANK, TOOLTIP_TANK, host.getInputTank()));
        addToolTip(new ToolTipTank(AREA_GREEN_TANK, TOOLTIP_TANK, host.getOutputTank()));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        drawStringCentered(LanguageUtility.getLocal("tile." + AtomicScience.PREFIX + "chem.centrifuge.gui"), xSize / 2, 5);
        drawString("Inventory", 8, 73);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY)
    {
        super.drawGuiContainerBackgroundLayer(f, mouseX, mouseY);
        drawContainerSlots();

        //Render progress arrow
        int x = 72;
        int y = 30;
        renderFurnaceCookArrow(x, y, host.processTimer, TileEntityChemCentrifuge.PROCESSING_TIME);

        drawFluidTank(8, 20, host.getInputTank(), Color.blue);
        drawFluidTank(155, 20, host.getOutputTank(), Color.green);

        drawElectricity(34, 15, host.getEnergyStored() / (float) host.getMaxEnergyStored());
    }
}
