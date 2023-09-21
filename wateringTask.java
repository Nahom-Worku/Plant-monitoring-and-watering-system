/*
             Nahom Worku
             EECS 1021
             MINOR PROJECT
 */
package eecs1021;

import java.io.IOException;
import java.util.TimerTask;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;

public class wateringTask extends TimerTask{
    public final int WetState = 575;
    private final Pin MoistureSensorPin;
    private final Pin PumpPin;
    private final SSD1306 myDisplay;

    public wateringTask(Pin MoistureSensorPin, Pin PumpPin, SSD1306 Display){
        this.myDisplay = Display;
        this.PumpPin = PumpPin;
        this.MoistureSensorPin = MoistureSensorPin;
    }

    @Override
    public void run() {
        long MoistureValue = MoistureSensorPin.getValue();
        String myString  = String.valueOf(MoistureValue);

        myDisplay.getCanvas().setTextsize(3);
        myDisplay.getCanvas().drawString(40,10,myString);
        myDisplay.display();

            try {
                if ((int)MoistureValue >= WetState) {
                    this.PumpPin.setValue(1);
                    myDisplay.getCanvas().clear();
                    myDisplay.getCanvas().setTextsize(2);
                    myDisplay.getCanvas().drawString(0,45,"Watering...");
                    myDisplay.display();
                    System.out.print("Soil is dry. The plant is being watered");
                    Thread.sleep(500);
                    System.out.print(".");
                    Thread.sleep(500);
                    System.out.print(".");
                    Thread.sleep(500);
                    System.out.println(".");
                    Thread.sleep(500);
                }
                else{
                    this.PumpPin.setValue(0);
                    myDisplay.getCanvas().clear();
                    myDisplay.getCanvas().setTextsize(2);
                    myDisplay.getCanvas().drawString(0, 45, "Watered");
                    myDisplay.display();
                    System.out.println("Soil is wet. The plant has been watered");
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            myDisplay.getCanvas().clear();
    }
}
