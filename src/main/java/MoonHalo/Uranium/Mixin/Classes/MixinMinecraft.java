package MoonHalo.Uranium.Mixin.Classes;

import MoonHalo.Uranium.Client.EventManager;
import MoonHalo.Uranium.Event.Classes.LoadEvent;
import net.minecraft.client.Minecraft;
import org.lwjgl.LWJGLException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;



@Mixin(Minecraft.class)
public abstract class MixinMinecraft {

    @Inject(method = "init",at = @At(value = "RETURN"))
    private void init(CallbackInfo ci) throws LWJGLException, IOException{
        EventManager.getInstance().PostEvent(new LoadEvent());
    }
}
