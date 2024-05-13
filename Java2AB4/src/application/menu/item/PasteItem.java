package application.menu.item;

import javafx.scene.control.TextField;

/**
 * Klasse für ein MenuItem, welches den Text in ein Textfeld aus der Zwischenablage kopiert.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class PasteItem extends ApplicationMenuItem
{ 

   /**
    * @see {@link ApplicationMenuItem#ApplicationMenuItem(TextField, String, String)}.
    */
   public PasteItem(TextField textfield)
   {
      super(textfield, "_Einfügen", "shortcut+v");
   }

   @Override
   protected void work()
   {
      textfield.paste();
   }

}

