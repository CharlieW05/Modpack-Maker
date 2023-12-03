package dabdaddy.mmm.modpackmaker.GUI;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Page
{
    public void updateGUI()
    {
        getPane().getChildren().clear();
        initGUIElements();
    }

    public void initGUIElements() { }
    public Pane getPane() { return new Pane(); }

    public int getWidth() { return 500; }
    public int getHeight() { return 600; }
}
