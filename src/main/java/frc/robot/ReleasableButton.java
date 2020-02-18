package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class ReleasableButton {
    boolean buttonState = false;
    double lastTime = 1000.0;

    /**
     * @param isPressed Whether the Button is Pressed
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

    boolean getStatus()
    {
        return buttonState;
    }

}
