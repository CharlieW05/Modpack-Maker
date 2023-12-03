package dabdaddy.mmm.modpackmaker;

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
        PageController controller = new PageController(stage);
        controller.registerPage(new TestPage());
    }

    public static void main(String[] args)
    {
        launch();
    }
}