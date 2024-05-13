package application.menu.item;

import javafx.scene.control.TextField;

/**
 * Klasse für ein MenuItem, welches den selektierten Text in einem Textfeld in die Zwischenablage kopiert.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class CopyItem extends ApplicationMenuItem
{

   /**
    * @see {@link ApplicationMenuItem#ApplicationMenuItem(TextField, String, String)}.
    */
   public CopyItem(TextField textfield)
   {
      super(textfield, "_Kopieren", "shortcut+c");
   }

   @Override
   protected void work()
   {
      textfield.copy();
   }


}
