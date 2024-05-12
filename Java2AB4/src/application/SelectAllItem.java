/**
 * 
 */
package application;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * Klasse für das MenuItem, welches den gesamten Text im Textfeld markiert.
 *
 * @author $Author:  Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class SelectAllItem extends MenuItem
{
   private TextField textfield;
   
   /**
    * Erstellt ein MenuItem, welches den gesamten Text im Textfeld markiert. 
    * 
    * @param textfield Textfeld, aus welchem der Text kopiert werden soll.
    */
   public SelectAllItem(TextField textfield)
   {
      super("Alles auswählen");
      if (textfield == null)      
         throw new IllegalArgumentException("CopyItem: Es wurde kein Textfeld übergeben!");
      
      this.textfield = textfield;
      setOnAction(e -> SelectAll());
   }
   
   /**
    * Markiert den gesamten Text im Textfeld.
    */
   private void SelectAll() {
      if (textfield.getText() != null)
      {
         textfield.selectAll();
      }
      
      
   }
}
