/**
 * 
 */
package application.menu.item;

import exception.LoggerFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCombination;

/**
 * TODO Add comment here
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe     
 */
   
public abstract class ApplicationMenuItem extends MenuItem
{
   
      TextField textfield;

      /**
       * Erstellt ein MenuItem, welches den Text aus einem Textfeld in die
       * Zwischenablage kopiert.
       * 
       * @param textfield Textfeld, aus welchem der Text kopiert werden soll.
       */
      public ApplicationMenuItem(TextField textfield,String nameButton,String shortcut)
      {
         super(nameButton);
         if (textfield == null) {
            throw new IllegalArgumentException("MenuItem: Es wurde kein Textfeld übergeben!");
         }
         
         this.textfield = textfield;
         
         this.setOnAction(new ItemEventHandler());

         this.setAccelerator(KeyCombination.keyCombination(shortcut));
      }

      /**
       * 
       * Handler welcher den Text in die Zwischenablage kopiert.
       *
       * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
       */
      protected class ItemEventHandler implements EventHandler<ActionEvent>{

         @Override
         public void handle(ActionEvent event)
         {
            try {
               work();
            }catch (Exception e) {
               Alert alert =
                     new Alert(AlertType.ERROR, "Fehler beim Kopieren! \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
               alert.setResizable(true);
               alert.showAndWait();
               LoggerFX.log(e, getClass().getSimpleName());
            }         
         }

      }

      protected abstract void work();
   
   }
   
   

   /*
    * probieren, die eine methode zu machen, die bei jeder klasse überschrieben wird
    * vllt in der handle methode im try block eine private methode machen 
    */
