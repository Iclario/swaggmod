package fr.ftnt.mineswagg.common;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import fr.ftnt.mineswagg.client.SwaggAmounts;
import io.netty.buffer.ByteBuf;

public class PacketSwaggAmountAnswer implements IMessage
{
    public static int swaggAmount, swaggLevel;

    public PacketSwaggAmountAnswer()
    {

    }

    public PacketSwaggAmountAnswer(int swaggAmount, int swaggLevel)
    {
        this.swaggAmount = swaggAmount;
        this.swaggLevel = swaggLevel;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.swaggAmount = buf.readInt();
        this.swaggLevel = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.swaggAmount);
        buf.writeInt(this.swaggLevel);
    }

    public static class Handler implements IMessageHandler<PacketSwaggAmountAnswer, IMessage>
    {
        @Override
        public IMessage onMessage(PacketSwaggAmountAnswer message, MessageContext ctx)
        {
            SwaggAmounts.swaggAmount = PacketSwaggAmountAnswer.swaggAmount;
            SwaggAmounts.swaggLevel = PacketSwaggAmountAnswer.swaggLevel;

            return null;
        }
    }
}
