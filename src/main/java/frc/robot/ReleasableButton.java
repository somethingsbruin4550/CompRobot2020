package frc.robot;

public class ReleasableButton {
    boolean buttonState = false;

    /**
     * @param isPressed Whether the Button is Pressed
     */
    boolean updateButton(boolean isPressed) {
        if(!buttonState && isPressed) {
            buttonState = true;
            return true;
        } else if(buttonState && !isPressed)
            buttonState = false;
        return false;
    }

}
