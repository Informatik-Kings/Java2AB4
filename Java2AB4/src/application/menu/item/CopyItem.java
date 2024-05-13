package application.menu.item;

import javafx.scene.control.TextField;

public class CopyItem extends ApplicationMenuItem
{ 
   public CopyItem(TextField textfield)
   {
      super(textfield, "Kopieren", "shortcut+c");
   }

   protected void work()
   {
      textfield.copy();
   }
   

}
