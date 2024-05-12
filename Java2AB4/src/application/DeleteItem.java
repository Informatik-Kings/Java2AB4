/**
 * 
 */
package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;

/**
 * Klasse für das MenuItem, welches den Text aus einem Textfeld löscht.
 *
 * @author $Author:  Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class DeleteItem extends MenuItem
{
   
   /**
    * Erstellt ein MenuItem, welches den markierten Text aus dem Textfeld löscht.
    * 
    * @param textfield Textfeld, aus welchem der markierte Text gelöscht werden soll.
    */
   public DeleteItem(TextField textfield)
   {
      super("_Löschen");
      if (textfield == null)      
         throw new IllegalArgumentException("DeleteItem: Es wurde kein Textfeld übergeben!");
      
      this.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
             textfield.deleteText(textfield.getSelection());
         }
     });
      
      this.setAccelerator(KeyCombination.keyCombination("shortcut+d"));
   }

}
