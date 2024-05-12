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
 * Klasse für das MenuItem, welches den Text aus einem Textfeld löscht.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class DeleteItem extends MenuItem
{
   TextField textfield;
   
   /**
    * Erstellt ein MenuItem, welches den markierten Text aus dem Textfeld löscht.
    * 
    * @param textfield Textfeld, aus welchem der markierte Text gelöscht werden soll.
    */
   public DeleteItem(TextField textfield)
   {
      super("_Löschen");
      if (textfield == null) {         
         throw new IllegalArgumentException("DeleteItem: Es wurde kein Textfeld übergeben!");
      }
      
      this.textfield = textfield;
      
      this.setOnAction(new DeleteItemEventHandler());
      
      this.setAccelerator(KeyCombination.keyCombination("shortcut+d"));
   }

   /**
    * 
    * Handler welcher den selektierten Text des Textfields löscht.
    *
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   private class DeleteItemEventHandler implements EventHandler<ActionEvent>{

      @Override
      public void handle(ActionEvent event)
      {
         try {
            textfield.deleteText(textfield.getSelection());
         }catch (Exception e) {
            Alert alert =
                  new Alert(AlertType.ERROR, "Fehler beim Löschen! \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
            alert.setResizable(true);
            alert.showAndWait();
            LoggerFX.log(e, getClass().getSimpleName());
         }         
      }

   }
   
}
