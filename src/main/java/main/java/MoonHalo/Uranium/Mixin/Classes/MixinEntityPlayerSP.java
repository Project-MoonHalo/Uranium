package MoonHalo.Uranium.Mixin.Classes;
import MoonHalo.Uranium.Client.ModuleManager;
import MoonHalo.Uranium.Uranium;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {

    @Inject(method = "sendChatMessage", at = @At(value = "HEAD"), cancellable = true)
    public void sendChatPacket(String message, CallbackInfo ci) {

        if(message.startsWith(Uranium.CommandPrefix)){
            ci.cancel();
            Uranium.logger.info("Execute command " + message);
            try {
                ModuleManager.getModuleByName(message.replaceFirst(".","").split(" ")[0]).OnExecute(message.split(" "));
                //getModuleByName("Help").OnExecute("hithere,hithere".split(","));
            } catch (ClassNotFoundException e) {
                Uranium.logger.info(message.replaceFirst(".",""));
                e.printStackTrace();
            }
        }
    }

}
