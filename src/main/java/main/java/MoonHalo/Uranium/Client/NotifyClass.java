package MoonHalo.Uranium.Client;

import MoonHalo.Uranium.Others.NotifyType;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

import static MoonHalo.Uranium.Uranium.ClientName;

@SuppressWarnings("New system does not use that.")
public class NotifyClass {
    String NotifyName;
    public NotifyClass(String name){
         NotifyName = name;
    }
    public static NotifyClass GetNotifyClass(String name){
        NotifyClass Manager=new NotifyClass(name);
        return Manager;
    }
    public void Notify(String Text, NotifyType type){
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("["+ClientName+"]"+Text));
    }
}
