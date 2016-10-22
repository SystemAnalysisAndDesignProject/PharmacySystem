
package com.pscontroller;

import com.psmodel.MainMenuModel;
import com.psview.MainMenuView;

public class MainMenuController {
    
    private MainMenuView mainMenuView;
    private MainMenuModel mainMenuModel;
    
    
    public MainMenuController(MainMenuView mainMenuView, MainMenuModel mainMenuModel){
        this.mainMenuView = mainMenuView;
        this.mainMenuModel = mainMenuModel;
        
        
    }
}
