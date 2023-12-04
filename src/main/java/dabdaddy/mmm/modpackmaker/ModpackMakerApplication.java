package dabdaddy.mmm.modpackmaker;

import dabdaddy.mmm.modpackmaker.Core.Mods.ModdingAPI;
import dabdaddy.mmm.modpackmaker.Core.Mods.ModdingAPIType;
import dabdaddy.mmm.modpackmaker.GUI.PageController;
import dabdaddy.mmm.modpackmaker.GUI.Pages.TestPage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ModpackMakerApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        // Initialise stage
        stage.setResizable(false);

        // Initialise components
        new ModdingAPI(ModdingAPIType.MODRINTH);

        // Setup page controller
        PageController controller = new PageController(stage);
        controller.registerPage(new TestPage());
    }

    public static void main(String[] args)
    {
        launch();
    }
}