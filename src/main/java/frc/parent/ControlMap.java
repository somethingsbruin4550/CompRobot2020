package frc.parent;

/**
 * This interface serves to have easy accsess to the port of the controller
 * This is not to be touched and/or modified. 
 * 
 * To accsess port: i.e. ControlMap.RT 
 */

public interface ControlMap {
    // Joystick Axises
    public static final int L_JOYSTICK_HORIZONTAL = 0;
    public static final int L_JOYSTICK_VERTICAL = 1;
    public static final int LT = 2;
    public static final int RT = 3;
    public static final int R_JOYSTICK_HORIZONTAL = 4;
    public static final int R_JOYSTICK_VERTICAL = 5;

    // Controller Buttons
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;
    public static final int LB_BUTTON = 5;
    public static final int RB_BUTTON = 6;
    public static final int BACK_BUTTON = 7;
    public static final int START_BUTTON = 8;
    // These buttons are when you push down the left and right circle pad
    public static final int L_JOYSTICK_BUTTON = 9;
    public static final int R_JOYSTICK_BUTTON = 10;

    // Controller Zeroes
    public static final double LEFT_Y_ZERO = -0.0078125;
    public static final double RIGHT_Y_ZERO = -0.0078125;

}