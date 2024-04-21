package Presentation;

import Controllers.KeyController;
import Controllers.MenuController;

/*This class is meant to manage the controllers and the presentation
* the creating of frame etc etc */
public class Manager {
    private KeyController keyControl;
    private MenuController menuControl;
    private SlideViewerFrame viewerFrame;
    public Manager(String title){
        this.viewerFrame = new SlideViewerFrame(title);
        this.keyControl = new KeyController(viewerFrame);

        this.menuControl = new MenuController(viewerFrame,viewerFrame.getViewComponent());
    }

    public KeyController getKeyControl() {
        return keyControl;
    }

    public MenuController getMenuControl() {
        return menuControl;
    }

    public SlideViewerFrame getViewerFrame() {
        return viewerFrame;
    }
}
