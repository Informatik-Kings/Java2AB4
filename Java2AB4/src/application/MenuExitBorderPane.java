package application;

import application.menu.ApplicationMenuBar;
import exception.InvalidSourceException;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

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
      HBox hbox = new HBox();

      TextField textfield = new TextField();
      ApplicationMenuBar menuBar = new ApplicationMenuBar(textfield);
      CountdownExitButton button = new CountdownExitButton(60);

      HBox.setHgrow(textfield, Priority.ALWAYS); // Textfeld nimmt den verfügbaren Platz ein
      hbox.getChildren().addAll(textfield, button);

      setTop(menuBar);
      setBottom(hbox);
      button.setAlignment(Pos.BOTTOM_RIGHT);
   }

}
