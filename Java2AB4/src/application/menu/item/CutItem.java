package application.menu.item;

import javafx.scene.control.TextField;

public class CutItem extends ApplicationMenuItem
{   
   public CutItem(TextField textfield)
   {
      super(textfield, "Ausschneiden", "shortcut+x");
   }

   protected void work()
   {
      textfield.cut();
   }
   

}

