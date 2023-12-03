package dabdaddy.mmm.modpackmaker.GUI;

import dabdaddy.mmm.modpackmaker.ApplicationUtils;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class PageController
{
    private List<Page> m_Pages = new ArrayList<>();
    private int m_CurrentPage = 0;
    private Stage m_MainStage;

    public PageController(Stage mainStage)
    {
        m_MainStage = mainStage;
    }

    /**
     * Registers a custom page to the controller that can then later be switched to
     * @param page The constructed Page class that the controller should register
     * @return     The index of the page that can be used to switch to it later
     */
    public int registerPage(Page page)
    {
        int index = m_Pages.size();
        page.initGUIElements();
        m_Pages.add(page);

        // If this page is the first to be registered, switch to it
        if(index == 0)
        {
            Scene scene = new Scene(page.getPane(), page.getWidth(), page.getHeight());
            m_MainStage.setScene(scene);
            m_MainStage.setWidth(page.getWidth());
            m_MainStage.setHeight(page.getHeight());
            m_MainStage.show();
        }

        return index;
    }

    /**
     * Switch the current page shown to a registered page in the controller
     * @param pageIndex The index of the page to be switched to
     */
    public void switchTo(int pageIndex)
    {
        if(pageIndex >= 0 && pageIndex < m_Pages.size())
        {
            Page page = m_Pages.get(pageIndex);
            m_CurrentPage = pageIndex;

            m_MainStage.getScene().setRoot(page.getPane());
            m_MainStage.setWidth(page.getWidth());
            m_MainStage.setHeight(page.getHeight());
        }
        else
        {
            ApplicationUtils.fatalError("Page index " + pageIndex + " is invalid!");
        }
    }

    /**
     * Show the main stage which displays the window
     */
    public void display()
    {
        m_MainStage.show();
    }
}
