package MoonHalo.Uranium.Mixin.Classes;
import MoonHalo.Uranium.Client.ModuleManager;
import MoonHalo.Uranium.Client.NotifyManager;
import MoonHalo.Uranium.Others.NotifyType;
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
        if(ModuleManager.MessageSendHook(message)){
            ci.cancel();
        }


        }
    }
