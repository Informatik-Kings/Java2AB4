package application.menu.item;

import javafx.scene.control.TextField;

/**
 * Klasse für ein MenuItem, welches den gesamten Text in einem Textfeld selektiert.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
public class SelectAllItem extends AbstractApplicationMenuItem
{ 

   /**
    * @see {@link AbstractApplicationMenuItem#ApplicationMenuItem(TextField, String, String)}.
    */
   public SelectAllItem(TextField textfield)
   {
      super(textfield, "Alles _markieren", "shortcut+a");
   }

   @Override
   protected void work()
   {
      textfield.selectAll();
   }

}

