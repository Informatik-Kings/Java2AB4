package application.menu.item;

import javafx.scene.control.TextField;

/**
 * Klasse für ein MenuItem, welches den Text in einen Textfeld löscht.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class DeleteItem extends ApplicationMenuItem
{ 

   /**
    * @see {@link ApplicationMenuItem#ApplicationMenuItem(TextField, String, String)}.
    */
   public DeleteItem(TextField textfield)
   {
      super(textfield, "_Löschen", "shortcut+d");
   }

   @Override
   protected void work()
   {
      textfield.deleteText(textfield.getSelection());
   }

}
