package MoonHalo.Uranium.Client;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class Notify {
    public Notify(String Text){
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString(Text));
    }
}
