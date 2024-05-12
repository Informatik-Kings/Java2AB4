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
 * Klasse für das MenuItem, welches den Text aus einem Textfeld in die Zwischenablage ausschneidet.
 *
 * @author $Author:  Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class PasteItem extends MenuItem
{   
   /**
    * Erstellt ein MenuItem, welches den Text aus der Zwischenablage in das Textfeld einfügt.
    * 
    * @param textfield Textfeld, aus welchem der Text kopiert werden soll.
    */
   public PasteItem(TextField textfield)
   {
      super("_Einfügen");
      if (textfield == null)      
         throw new IllegalArgumentException("CopyItem: Es wurde kein Textfeld übergeben!");
      
      this.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent event) {
             textfield.paste();
         }
     });
      
      this.setAccelerator(KeyCombination.keyCombination("shortcut+v"));
   }
   
   /**
    * Fügt den Text aus der Zwischenablage in das Textfeld an der Stelle von "Caret"(dem Strich) ein.
    *//*
   private void paste() {
      Clipboard clipboard = Clipboard.getSystemClipboard();
      
      if (clipboard == null)
         throw new IllegalArgumentException("Fehler beim Zugriff auf die Zwischenablage!");
      
      if (clipboard.hasString())
      {
         textfield.insertText(textfield.getCaretPosition(),clipboard.getString());
      }
      
      
   }*/
}
