package dabdaddy.mmm.modpackmaker.GUI.Pages;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import dabdaddy.mmm.modpackmaker.Core.Mods.ModdingAPI;
import dabdaddy.mmm.modpackmaker.GUI.Page;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TestPage extends Page
{
    private VBox m_Root = new VBox(5);

    @Override
    public void initGUIElements()
    {
        JsonObject prj = ModdingAPI.s_Instance.getAPI().getProject("jei");

        Label title = new Label(prj.get("title").getAsString());
        title.setStyle("-fx-font: 18 arial;");
        Label description = new Label(prj.get("description").getAsString());

        m_Root.setAlignment(Pos.CENTER);
        m_Root.getChildren().addAll(title, description);
    }

    @Override
    public Pane getPane()
    {
        return m_Root;
    }
}
