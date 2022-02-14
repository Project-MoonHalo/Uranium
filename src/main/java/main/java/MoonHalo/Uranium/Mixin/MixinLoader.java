package MoonHalo.Uranium.Mixin;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

    @IFMLLoadingPlugin.TransformerExclusions({"MoonHalo.Uranium.asm"})
    @IFMLLoadingPlugin.MCVersion("1.12.2")
    @IFMLLoadingPlugin.Name("Uranium")
    @IFMLLoadingPlugin.SortingIndex(value = 1001)
    public class MixinLoader implements IFMLLoadingPlugin {

        public static final Logger logger = LogManager.getLogger("UraniumCoreMod");

        public MixinLoader() {
            logger.info("Uranium's mixin is ready.");
            MixinBootstrap.init();
            Mixins.addConfigurations("mixins.Uranium.json");
            MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
            logger.info(MixinEnvironment.getDefaultEnvironment().getObfuscationContext());
        }

        @Override
        public String[] getASMTransformerClass() {
            return new String[0];
        }

        @Override
        public String getModContainerClass() {
            return null;
        }

        @Override
        public String getSetupClass() {
            return null;
        }

        @Override
        public void injectData(Map<String, Object> data) { }

        @Override
        public String getAccessTransformerClass() {
            return null;
        }

    }

