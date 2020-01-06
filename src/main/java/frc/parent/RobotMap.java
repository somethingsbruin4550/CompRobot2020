package frc.parent;

/*
    RobotMap holds all the ports involved in the robot.
    This ranges from talon ports, all the way to the ports
    on the controllers. This also contains the polarity for the wheels
    and the various ports assoiated with sensors

    If you wish to create your own port, here is the syntax:
        public static final returnType name = value;
    Notes on creating ports:
        1. Ports must be integers or booleans
        2. they MUST be public static final;
        3. If the port is not plugged in, make int values -1, and boolean values false


*/
public interface RobotMap {

    // Wheel Talons
    public static final int FORWARD_LEFT = -1;
    public static final int FORWARD_RIGHT = -1;
    public static final int BACK_LEFT = -1;
    public static final int BACK_RIGHT = -1;

    // Wheel Talon Polarity
    public static final boolean FL_REVERSE = false;
    public static final boolean FR_REVERSE = false;
    public static final boolean BL_REVERSE = false;
    public static final boolean BR_REVERSE = false;

    // Wheel Encoder Ports
    public static final int ENCODER_A_LEFT = -1;
    public static final int ENCODER_B_LEFT = -1; 
    public static final int ENCODER_A_RIGHT = -1;
    public static final int ENCODER_B_RIGHT = -1; 
    public static final int ENCODER_TURRET = -1;
    
    //Analog
    public static final int POTENTIOMETER = -1; 

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
    public static final int SELECT_BUTTON = 7;
    public static final int START_BUTTON = 8;
    // These buttons are when you push down the left and right circle pad
    public static final int L_JOYSTICK_BUTTON = 9;
    public static final int R_JOYSTICK_BUTTON = 10;

    // Controller Zeroes
    public static final double LEFT_Y_ZERO = -0.0078125;
    public static final double RIGHT_Y_ZERO = -0.0078125;

    // Talon Ports for Intake
    public static final int INTAKE_A = -1;
    public static final int INTAKE_B = -1;

    // Talon ports for Climber
    public static final int CLIMBER = -1;

    // Talon ports for the yeeter
    public static final int YEETER = -1;

}