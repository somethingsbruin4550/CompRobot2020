package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * In regualar controllers, the DPad is considered an axis, like a joystick
 * This class converts that axis into 4 buttons: Up, Down, Left, and Right
 */

public class DPadButton extends Button {

    Joystick joystick;
    Direction direction;

    public DPadButton(Joystick joystick, Direction direction) {
        this.joystick = joystick;
        this.direction = direction;
    }

    public static enum Direction {
        UP(0), RIGHT(90), DOWN(180), LEFT(270);
        //converts degrees to directions
        int direction;

        private Direction(int direction) {
            this.direction = direction;
        }
    }

    public boolean get() {
        int dPadValue = joystick.getPOV();
        return (dPadValue == direction.direction) 
        || (dPadValue == (direction.direction + 45) % 360) 
        || (dPadValue == (direction.direction + 315) % 360);
        //returns true if the value got by dPad is equal to the direction you're at, if 
    }

}
