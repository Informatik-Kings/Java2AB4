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
 * Klasse für das MenuItem, welches den gesamten Text im Textfeld markiert.
 *
 * @author $Author:  Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class SelectAllItem extends MenuItem
{   
   /**
    * Erstellt ein MenuItem, welches den gesamten Text im Textfeld markiert. 
    * 
    * @param textfield Textfeld, aus welchem der Text kopiert werden soll.
    */
   public SelectAllItem(TextField textfield)
   {
      super("Alles _markieren");
      if (textfield == null)      
         throw new IllegalArgumentException("CopyItem: Es wurde kein Textfeld übergeben!");

      this.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
             textfield.selectAll();
         }
     });
      
      this.setAccelerator(KeyCombination.keyCombination("shortcut+a"));
   }
   
   /**
    * Markiert den gesamten Text im Textfeld.
    *//*
   private void SelectAll() {
      if (textfield.getText() != null)
      {
         textfield.selectAll();
      }
      
      
   }*/
}
