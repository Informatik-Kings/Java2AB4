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
 * Klasse für das MenuItem, welches den Text aus einem Textfeld in die Zwischenablage kopiert.
 *
 * @author $Author:  Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class CopyItem extends MenuItem
{ 
   /**
    * Erstellt ein MenuItem, welches den Text aus einem Textfeld in die
    * Zwischenablage kopiert.
    * 
    * @param textfield Textfeld, aus welchem der Text kopiert werden soll.
    */
   public CopyItem(TextField textfield)
   {
      super("_Kopieren");
      if (textfield == null)      
         throw new IllegalArgumentException("CopyItem: Es wurde kein Textfeld übergeben!");
      
      this.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
            textfield.copy(); 
         }
     });
      
      this.setAccelerator(KeyCombination.keyCombination("shortcut+c"));
   }
   
   /**
    * Kopiert den markierten Text aus dem Textfeld in die Zwischenablage.
    *//*
   private void copy() {
      Clipboard clipboard = Clipboard.getSystemClipboard();
      
      if (clipboard == null)
         throw new IllegalArgumentException("Fehler beim Zugriff auf die Zwischenablage!");
      
      if (textfield.getSelectedText() != null)
      {
         ClipboardContent content = new ClipboardContent();
         content.putString(textfield.getSelectedText());
         clipboard.setContent(content);
      }
      
      
   }*/
}
