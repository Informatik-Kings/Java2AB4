/**
 * 
 */
package application;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;

/**
 * MenuBar, welche die verschiedenen Menüfunktionen für das Textfeld bereitstellt.
 *
 * @author $Author:   Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class ApplicationMenuBar extends MenuBar
{   
   public ApplicationMenuBar(TextField textfield)
   {
      if (textfield == null)
      {
         throw new IllegalArgumentException(
               "ApplicationMenuBar(TextField textfield): textfield == null!");
      }
      EditMenu menu = new EditMenu(textfield);
      this.getMenus().add(menu);
   }
   
   
   /**
    * EditMenu, welches die Menüpunkte für das Editieren von Text bereitstellt.
    */
   public class EditMenu extends Menu
   {
      public EditMenu(TextField textfield)
      {
         super("Bearbeiten");
         if (textfield == null)
         {
            throw new IllegalArgumentException(
                  "ApplicationMenuBar(TextField textfield): textfield == null!");
         }
         CopyItem copyItem = new CopyItem(textfield);
         getItems().add(copyItem);
         
         CutItem cutItem = new CutItem(textfield);
         getItems().add(cutItem);
         
         PasteItem pasteItem = new PasteItem(textfield);
         getItems().add(pasteItem);
         
         SelectAllItem selectAllItem = new SelectAllItem(textfield);
         getItems().add(selectAllItem);
         
      }
   }
}
