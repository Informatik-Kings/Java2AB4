package application.menu.item;


import javafx.scene.control.TextField;

public class DeleteItem extends ApplicationMenuItem
{ 
   public DeleteItem(TextField textfield)
   {
      super(textfield, "Kopieren", "shortcut+a");
   }

   protected void work()
   {
      textfield.deleteText(textfield.getSelection());
   }
      
}
