package application;

import application.menu.ApplicationMenuBar;
import exception.InvalidSourceException;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Beispiel Darstellung für {@link CountdownExitButton} und {@link ApplicationMenuBar}.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class MenuExitBorderPane extends BorderPane {

   /**
    * Setzt den Button in eine VBox und setzt es als ins Center einer BorderPane.
    * 
    * @throws InvalidSourceException
    */
   public MenuExitBorderPane() throws InvalidSourceException {
      VBox vbox = new VBox();
      
      CountdownExitButton button = new CountdownExitButton(60);
      button.setAlignment(Pos.TOP_CENTER);
      vbox.getChildren().add(button);
      
      TextField textfield = new TextField();
      textfield.setAlignment(Pos.CENTER);
      vbox.getChildren().add(textfield);
      ApplicationMenuBar menuBar = new ApplicationMenuBar(textfield);
      vbox.getChildren().add(menuBar);
      
      
      setCenter(vbox);
   }

}
