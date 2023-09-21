/*
             Nahom Worku
             EECS 1021
             MINOR PROJECT
 */
package eecs1021;

import org.firmata4j.I2CDevice;
import org.firmata4j.firmata.*;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;
import java.io.IOException;
import java.util.Timer;

public class Main {
    public static int A0 = 14;
    public static int D7 = 7;

    public static void main(String[] args)  throws IOException{

        String myPort = "COM7";
        IODevice myGroveBoard = new FirmataDevice(myPort);
        try {
            myGroveBoard.start();
            System.out.println("Board started.");
            myGroveBoard.ensureInitializationIsDone();
        }
        catch (Exception ex) {
            System.out.println("couldn't connect to board.");
        }
        finally {
            I2CDevice I2C = myGroveBoard.getI2CDevice((byte) 0x3C);
            SSD1306 OLED = new SSD1306(I2C, SSD1306.Size.SSD1306_128_64);
            OLED.init();

            var moistureSensor = myGroveBoard.getPin(A0);
            moistureSensor.setMode(Pin.Mode.ANALOG);

            var pump = myGroveBoard.getPin(D7);
            pump.setMode(Pin.Mode.OUTPUT);

            var myTask = new wateringTask(moistureSensor,pump, OLED);
            new Timer().schedule(myTask,0,1000);
        }
    }
}
