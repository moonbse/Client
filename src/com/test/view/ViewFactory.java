package com.test.view;

import com.test.EmailManager;

import com.test.controller.BaseController;
import com.test.controller.LoginWindowController;
import com.test.controller.MainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.test.controller.OptionsWindowController;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private EmailManager emailManager;

    private ArrayList<Stage> activeStages;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }

    //View options handling:
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }
    public void showLoginWindow(){
        System.out.println("show login window called");
        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        initializeStage(controller);
//        activeStages.add(stage);


    }

     public void showMainWindow(){
         System.out.println("show Main window called");
         BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
         initializeStage(controller);
     }

     private void initializeStage(BaseController controller){
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
         fxmlLoader.setController(controller);
         Parent parent;
         try {
             parent = fxmlLoader.load();
         } catch (IOException e) {
             e.printStackTrace();
             return;
         }
         Scene scene = new Scene(parent);
         Stage stage = new Stage();
         stage.setScene(scene);
         stage.show();
         activeStages.add(stage);
     }

    public void showOptionsWindow(){
        System.out.println("options window called");
        BaseController controller = new OptionsWindowController(emailManager, this, "OptionWindow.fxml");
        initializeStage(controller);
    }
     public void closeStage(Stage stageToClose){
        stageToClose.close();
         activeStages.remove(stageToClose);
     }
    public void updateAllStyles() {
        for (Stage stage: activeStages) {
            Scene scene = stage.getScene();
            updateStyle(scene);
        }
    }

    private void updateStyle(Scene scene){
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
        scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
    }

    public boolean isMainViewInitialized() {
        return false;
    }
}
