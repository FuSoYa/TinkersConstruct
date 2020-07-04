package slimeknights.tconstruct.tables.tileentity.table;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraftforge.common.util.LazyOptional;
import slimeknights.tconstruct.shared.inventory.ConfigurableInvWrapperCapability;
import slimeknights.tconstruct.tables.TinkerTables;
import slimeknights.tconstruct.tables.inventory.table.partbuilder.PartBuilderContainer;
import slimeknights.tconstruct.tables.tileentity.TableTileEntity;

import javax.annotation.Nullable;

public class PartBuilderTileEntity extends TableTileEntity {
  public static final int MATERIAL_SLOT = 0;
  public static final int PATTERN_SLOT = 1;
  public static final int LEFTOVER_SLOT = 2;

  public PartBuilderTileEntity() {
    super(TinkerTables.partBuilderTile.get(), "gui.tconstruct.part_builder", 3);
    this.itemHandler = new ConfigurableInvWrapperCapability(this, false, false);
    this.itemHandlerCap = LazyOptional.of(() -> this.itemHandler);
  }

  @Nullable
  @Override
  public Container createMenu(int menuId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
    return new PartBuilderContainer(menuId, playerInventory, this);
  }
}
