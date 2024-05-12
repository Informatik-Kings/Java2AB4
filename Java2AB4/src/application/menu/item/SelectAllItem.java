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
 * Klasse für das MenuItem, welches den gesamten Text im Textfeld markiert.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class SelectAllItem extends MenuItem
{   
   TextField textfield;
   
   /**
    * Erstellt ein MenuItem, welches den gesamten Text im Textfeld markiert. 
    * 
    * @param textfield Textfeld, aus welchem der Text kopiert werden soll.
    */
   public SelectAllItem(TextField textfield)
   {
      super("Alles _markieren");
      if (textfield == null) {         
         throw new IllegalArgumentException("CopyItem: Es wurde kein Textfeld übergeben!");
      }

      this.textfield = textfield;
      
      this.setOnAction(new SelectAllItemEventHandler());
      
      this.setAccelerator(KeyCombination.keyCombination("shortcut+a"));
   }
   
   /**
    * 
    * Handler welcher den gesamten Text des Textfields selektiert.
    *
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   private class SelectAllItemEventHandler implements EventHandler<ActionEvent>{

      @Override
      public void handle(ActionEvent event)
      {
         try {
            textfield.selectAll();
         }catch (Exception e) {
            Alert alert =
                  new Alert(AlertType.ERROR, "Fehler beim Selektieren! \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
            alert.setResizable(true);
            alert.showAndWait();
            LoggerFX.log(e, getClass().getSimpleName());
         }         
      }

   }
}
