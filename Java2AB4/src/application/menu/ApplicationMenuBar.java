package application.menu;

import application.menu.item.CopyItem;
import application.menu.item.CutItem;
import application.menu.item.DeleteItem;
import application.menu.item.PasteItem;
import application.menu.item.SelectAllItem;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;

/**
 * MenuBar, welche die verschiedenen Menüfunktionen für das Textfeld bereitstellt.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
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
      
      private TextField textField;
      private MenuItem cutItem;
      private MenuItem copyItem;
      private MenuItem pasteItem;
      private MenuItem deleteItem;
      private MenuItem selectAllItem;
      
      public EditMenu(TextField textfield)
      {
         super("_Bearbeiten");
         if (textfield == null)
         {
            throw new IllegalArgumentException(
                  "ApplicationMenuBar(TextField textfield): textfield == null!");
         }
         this.textField = textfield;
         this.copyItem = new CopyItem(textfield);
         getItems().add(copyItem);
         
         this.cutItem = new CutItem(textfield);
         getItems().add(cutItem);
         
         this.pasteItem = new PasteItem(textfield);
         getItems().add(pasteItem);
         
         this.deleteItem = new DeleteItem(textfield);
         getItems().add(deleteItem);
         
         this.selectAllItem = new SelectAllItem(textfield);
         getItems().add(selectAllItem);
         
         setOnShown(new UpdateMenuItemsEventHandler());
      }
      
      private class UpdateMenuItemsEventHandler implements EventHandler<Event> {
         @Override
         public void handle(Event event) {
             boolean selectedText = !textField.getSelectedText().isEmpty();
             boolean clipboardText = Clipboard.getSystemClipboard().hasString();
             
             cutItem.setDisable(!selectedText);
             copyItem.setDisable(!selectedText);
             pasteItem.setDisable(!clipboardText);
             deleteItem.setDisable(!selectedText);
             selectAllItem.setDisable(textField.getText().isEmpty());
         }
      }
      
   }
}
