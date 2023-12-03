package dabdaddy.mmm.modpackmaker.GUI.Pages;

import dabdaddy.mmm.modpackmaker.GUI.Page;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class TestPage extends Page
{
    private StackPane m_Root = new StackPane();

    @Override
    public void initGUIElements()
    {
        Label lbl = new Label("Test Page");

        m_Root.setAlignment(Pos.CENTER);
        m_Root.getChildren().add(lbl);
    }

    @Override
    public Pane getPane()
    {
        return m_Root;
    }
}
