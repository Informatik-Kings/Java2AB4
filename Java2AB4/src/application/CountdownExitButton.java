package application;

import exception.InvalidSourceException;
import exception.LoggerFX;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;

/**
 * Ein Button welcher einen Countdown als Text anzeigt. Der Countdown wird jede Sekunde runtergezählt.
 * Wenn der Countdown abläuft oder der Button gedrückt wird, wird das Programm geschlossen.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class CountdownExitButton extends Button
{
   private int timeout;
   private final static int DEFAULT_TIMEOUT = 5;
   private final static String COUNTDOWN_FORMAT = "Exit[%d]";

   /**
    * Erstellt einen Button mit einem default Countdown von 5 Sekunden.
    * @throws InvalidSourceException @see {@link CountdownExitButton#CountdownExitButton(int)}.
    */
   public CountdownExitButton() throws InvalidSourceException
   {
      this(DEFAULT_TIMEOUT);
   }

   /**
    * Erstellt einen Button mit dem übergebenen timeout als Countdown.
    *
    * @param timeout Sekunden Anzahl >= 0 ab wann das Programm geschlossen werden soll.
    * @throws InvalidSourceException Wenn timeout < 0.
    */
   public CountdownExitButton(int timeout) throws InvalidSourceException
   {
      if(timeout < 0) {
         throw new InvalidSourceException("CountdownExitButton(int timeout): timeout < 0!");
      }
      this.timeout = timeout;
      setOnAction(new CountdownButtonEventHandler());
      Timeline timeline = new Timeline();
      timeline.setCycleCount(Timeline.INDEFINITE);
      setText(String.format(COUNTDOWN_FORMAT, this.timeout));
      timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1),
            (new CountdownEventHandler())));
      timeline.playFromStart();
   }

   /**
    * 
    * Aktuallisiert den Countdown des Buttons und löst den Button nach dem Ablauf aus.
    *
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   public class CountdownEventHandler implements EventHandler<ActionEvent> {

      @Override
      public void handle(ActionEvent event)
      {
         try {            
            timeout--;
            setText(String.format(COUNTDOWN_FORMAT, timeout));        
            if(timeout <= 0) {
               fire();
            }
         }catch (Exception e) {
            Alert alert =
                  new Alert(AlertType.ERROR, "Fehler beim Countdown! \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
            alert.setResizable(true);
            alert.showAndWait();
            LoggerFX.log(e, getClass().getSimpleName());
         }
      }

   }

   /**
    * 
    * Aktuallisiert den Countdown des Buttons und löst den Button nach dem Ablauf aus.
    *
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   public class CountdownButtonEventHandler implements EventHandler<ActionEvent> {

      @Override
      public void handle(ActionEvent event)
      {
         try {
            Platform.exit();
         }catch (Exception e) {
            Alert alert =
                  new Alert(AlertType.ERROR, "Fehler beim Drücken des Exit Buttons! \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
            alert.setResizable(true);
            alert.showAndWait();
            LoggerFX.log(e, getClass().getSimpleName());
         }

      }

   }

}
