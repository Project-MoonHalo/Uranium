package HorizonLN.Uranium.Modules.Modules.Combat;
import HorizonLN.Uranium.Modules.Module;
import HorizonLN.Uranium.Uranium;
import org.apache.logging.log4j.Logger;

import static HorizonLN.Uranium.Others.ModuleType.Combat;

public class TestAttack extends Module{
    public TestAttack() {
        super("TestAttack",Combat);
    }
    @Override
    public void OnEnable(){
        Uranium.logger.info(GetName());
    }
}
