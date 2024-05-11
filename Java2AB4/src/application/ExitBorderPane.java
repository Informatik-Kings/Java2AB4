package application;

import exception.InvalidSourceException;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Beispiel Darstellung für {@link CountdownExitButton}.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class ExitBorderPane extends BorderPane {

   /**
    * Setzt den Button in eine VBox und setzt es als ins Center einer BorderPane.
    * 
    * @throws InvalidSourceException
    */
   public ExitBorderPane() throws InvalidSourceException {
      CountdownExitButton button = new CountdownExitButton(10);
      VBox vbox = new VBox();
      vbox.getChildren().add(button);
      vbox.setAlignment(Pos.CENTER);
      setCenter(vbox);
   }

}
