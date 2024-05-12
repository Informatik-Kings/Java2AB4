package application.menu.item;

import exception.LoggerFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCombination;

/**
 * Klasse für das MenuItem, welches den Text aus einem Textfeld in die Zwischenablage ausschneidet.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class CutItem extends MenuItem
{  
   TextField textfield;
   
   /**
    * Erstellt ein MenuItem, welches den Text aus einem Textfeld in die
    * Zwischenablage ausscneidet.
    * 
    * @param textfield Textfeld, aus welchem der Text kopiert werden soll.
    */
   public CutItem(TextField textfield)
   {
      super("_Ausschneiden");
      if (textfield == null) {         
         throw new IllegalArgumentException("CutItem: Es wurde kein Textfeld übergeben!");
      }
      
      this.textfield = textfield;
      
      this.setOnAction(new CutItemEventHandler());
      
      this.setAccelerator(KeyCombination.keyCombination("shortcut+x"));
   }

   /**
    * 
    * Handler welcher den Text in die Zwischenablage ausschneidet.
    *
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   private class CutItemEventHandler implements EventHandler<ActionEvent>{

      @Override
      public void handle(ActionEvent event)
      {
         try {
            textfield.cut();
         }catch (Exception e) {
            Alert alert =
                  new Alert(AlertType.ERROR, "Fehler beim Ausschneiden! \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
            alert.setResizable(true);
            alert.showAndWait();
            LoggerFX.log(e, getClass().getSimpleName());
         }         
      }

   }
   
}