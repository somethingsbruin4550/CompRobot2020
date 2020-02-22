package frc.robot;

import edu.wpi.first.wpilibj.Timer;

/**
 * This allows for the ability to have button presses, not just button holds
 */
public class ReleasableButton {
    boolean buttonState = false;
    double lastTime = 1000.0;

    /**
     * @param isPressed Whether the Button is Pressed
     * This allows for the button to be restricted to a certain number of pressed
     * Delay is how long until a driver can press a button
     */
    boolean updateButton(boolean isPressed, double delay)
    {
        if(lastTime - Timer.getMatchTime() > delay)
        {
            if(!buttonState && isPressed)
            {
                buttonState = true;
                return true;
            } 
            else if(buttonState && !isPressed)
            {
                buttonState = false;
            }
            lastTime = Timer.getMatchTime();
        }
        return false;
    }

    /**
     * 
     * @return The status of the button
     */
    boolean getStatus()
    {
        return buttonState;
    }

}
