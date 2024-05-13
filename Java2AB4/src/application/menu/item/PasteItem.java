package application.menu.item;


import javafx.scene.control.TextField;

public class PasteItem extends ApplicationMenuItem
{ 
   public PasteItem(TextField textfield)
   {
      super(textfield, "Einfügen", "shortcut+v");
   }

   protected void work()
   {
      textfield.deleteText(textfield.getSelection());
   }
      
}

