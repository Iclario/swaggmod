package fr.ftnt.mineswagg.common.blocks;

import fr.ftnt.mineswagg.common.ExtendedEntity;
import fr.ftnt.mineswagg.common.MineSwagg;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockSwaggTester extends Block
{
    public static int swaggAmount, swaggLevel, maxSwagg;

    public BlockSwaggTester()
    {
        super(Material.iron);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundTypePiston);
        this.setBlockName("swaggTester");
        this.setBlockTextureName(MineSwagg.MODID + ":swaggium_block");
        // this.setBlockTextureName(MineSwagg.MODID + ":swagg_tester");
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float posX, float posY, float posZ)
    {
        ExtendedEntity props = ExtendedEntity.get(player);

        if(side == 1)
            props.addSwagg(5);

        if(side == 0)
            props.consumeSwagg(5);

        System.out.println((!world.isRemote ? "Server: " : "Client: ") + "Swagg: " + props.getSwaggAmount());
        System.out.println((!world.isRemote ? "Server: " : "Client: ") + "Swagg total: " + (props.getSwaggAmount() + props.getSwaggLevel() * props.getMaxSwagg()));
        System.out.println((!world.isRemote ? "Server: " : "Client: ") + "Swagg level: " + props.getSwaggLevel() + "\n");

        // System.out.println("Side: " + side);

        this.swaggAmount = props.getSwaggAmount();
        this.swaggLevel = props.getSwaggLevel();
        this.maxSwagg = props.getMaxSwagg();

        return true;
    }
}