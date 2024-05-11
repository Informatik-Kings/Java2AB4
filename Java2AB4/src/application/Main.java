package application;
	
import exception.InvalidSourceException;
import exception.LoggerFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * 
 * TODO COMMENT
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class Main extends Application
{

   /**
    * 
    * Startet die JavaFX-Runtime.
    *
    * @param args Keine Verwendung.
    */
   public static void main(String[] args)
   {
      launch(args);
   }

   /**
    * Wird durch JavaFX-Runtime nach dem Aufruf der init-Methode aufgerufen.
    * Initialisert die primaryStage mit einer {@link ExitBorderPane}.
    */
   @Override
   public void start(Stage primaryStage) throws InvalidSourceException
   {
      try
      {
         if(primaryStage == null) 
         {
            throw new InvalidSourceException("Main.start(Stage primaryStage): Ungültige Null-Referenz zu PrimaryStage!");
         }

         ExitBorderPane root = new ExitBorderPane();
         Scene scene = new Scene(root,600,300);
         primaryStage.setTitle("Main");
         primaryStage.setScene(scene);
         primaryStage.show();

      }
      catch (InvalidSourceException e)
      {
         Alert alert =
               new Alert(AlertType.ERROR, "Unbekannter Fehler \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
         alert.setResizable(true);
         alert.showAndWait();
         LoggerFX.log(e, getClass().getSimpleName());
      }
   }
}
