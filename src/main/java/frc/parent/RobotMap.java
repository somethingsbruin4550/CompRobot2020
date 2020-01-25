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
    
    //Other
    public static final int POTENTIOMETER = -1; 
    public static final int PCM_CAN = -1; 
    public static final int PCM_SOLENOID = -1; 
    // Talon Ports for Intake
    public static final int INTAKE_A = -1;
    public static final int INTAKE_B = -1;

    // Talon ports for Climber
    public static final int CLIMBER = -1;

    // Talon ports for the yeeter
    public static final int YEETER_ONE = -1;
    public static final int YEETER_TWO = -1;

}