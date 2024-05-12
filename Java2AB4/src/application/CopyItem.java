/**
 * 
 */
package application;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

/**
 * Klasse für das MenuItem, welches den Text aus einem Textfeld in die Zwischenablage kopiert.
 *
 * @author $Author:  Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class CopyItem extends MenuItem
{
   private TextField textfield;
   
   /**
    * Erstellt ein MenuItem, welches den Text aus einem Textfeld in die
    * Zwischenablage kopiert.
    * 
    * @param textfield Textfeld, aus welchem der Text kopiert werden soll.
    */
   public CopyItem(TextField textfield)
   {
      super("Kopieren");
      if (textfield == null)      
         throw new IllegalArgumentException("CopyItem: Es wurde kein Textfeld übergeben!");
      
      this.textfield = textfield;
      setOnAction(e -> copy());
   }
   
   /**
    * Kopiert den markierten Text aus dem Textfeld in die Zwischenablage.
    */
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
      
      
   }
}
