package application.menu.item;

import javafx.scene.control.TextField;

/**
 * Klasse für ein MenuItem, welches den selektierten Text aus einem Textfeld ausschneidet.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class CutItem extends AbstractApplicationMenuItem
{   

   /**
    * @see {@link AbstractApplicationMenuItem#ApplicationMenuItem(TextField, String, String)}.
    */
   public CutItem(TextField textfield)
   {
      super(textfield, "_Ausschneiden", "shortcut+x");
   }

   @Override
   protected void work()
   {
      textfield.cut();
   }


}

