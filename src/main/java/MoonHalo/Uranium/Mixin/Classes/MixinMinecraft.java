package MoonHalo.Uranium.Mixin.Classes;

import MoonHalo.Uranium.Event.Classes.PreLoadEvent;
import MoonHalo.Uranium.Uranium;
import net.minecraft.client.Minecraft;
import org.lwjgl.LWJGLException;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;



@Mixin(Minecraft.class)
public abstract class MixinMinecraft {

    @Inject(method = "init",at = @At(value = "INVOKE",target = "Lnet/minecraft/client/Minecraft;checkGLError(Ljava/lang/String;)V",ordinal = 0))
    private void init(CallbackInfo ci) throws LWJGLException, IOException{
        Uranium.logger.debug("Init!!!!!");
        Uranium.EventBus.Post(new PreLoadEvent());
    }
    @Inject(method = "init",at=@At(value = "RETURN"))
    private void PostInit(CallbackInfo ci){

    }
    @Inject(method = "shutdown",at = @At(value = "HEAD"))
    private void Shutdown(CallbackInfo ci){
        Uranium.logger.info("Game shutdown.");
    }
}
