package application.menu.item;


import javafx.scene.control.TextField;

public class SelectAllItem extends ApplicationMenuItem
{ 
   public SelectAllItem(TextField textfield)
   {
      super(textfield, "Alles auswählen", "shortcut+b");
   }

   protected void work()
   {
      textfield.selectAll();
   }
      
}

