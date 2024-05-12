/**
 * 
 */
package application;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

/**
 * Klasse für das MenuItem, welches den Text aus einem Textfeld in die Zwischenablage ausschneidet.
 *
 * @author $Author:  Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class CutItem extends MenuItem
{
   private TextField textfield;
   
   /**
    * Erstellt ein MenuItem, welches den Text aus einem Textfeld in die
    * Zwischenablage ausscneidet.
    * 
    * @param textfield Textfeld, aus welchem der Text kopiert werden soll.
    */
   public CutItem(TextField textfield)
   {
      super("Ausschneiden");
      if (textfield == null)      
         throw new IllegalArgumentException("CutItem: Es wurde kein Textfeld übergeben!");
      
      this.textfield = textfield;
      setOnAction(e -> cut());
   }

   /**
    * Schneidet den markierten Text aus dem Textfeld in die Zwischenablage.
    */
   private void cut() {
      Clipboard clipboard = Clipboard.getSystemClipboard();
      
      if (clipboard == null)
         throw new IllegalArgumentException("Fehler beim Zugriff auf die Zwischenablage!");
      
      if (textfield.getSelectedText() != null)
      {
         ClipboardContent content = new ClipboardContent();
         content.putString(textfield.getSelectedText());
         clipboard.setContent(content);
         textfield.deleteText(textfield.getSelection());
      }
      
      
   }
}
