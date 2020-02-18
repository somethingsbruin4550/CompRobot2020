package frc.parent;

public interface RobotMap {

    public static final int NUM_JOYSTICKS = 3;

    // Wheel Talons
    public static final int FORWARD_LEFT = 1;
    public static final boolean FL_REVERSE = true;
    public static final int BACK_LEFT = 2;
    public static final boolean BL_REVERSE = true;
    public static final int FORWARD_RIGHT = 3;
    public static final boolean FR_REVERSE = false;
    public static final int BACK_RIGHT = 4;
    public static final boolean BR_REVERSE = false;

    public static final int SHIFT_SOLENOID = 0;

    // Motor Ports for Intake
    public static final int INTAKE = 8;
    public static final boolean INTAKE_REVERSE = false;
    public static final int INTAKE_SOLENDOID = 1;

    // Motor ports for Climber
    // public static final int CLIMBER = -1;

    public static final int LOADER = 6;
    public static final boolean LOADER_REVERSE = false;
    public static final int SPINDEXER = 7;
    public static final boolean SPINDEXER_REVERSE = false;

    // Motor ports for the yeeter
    public static final int SHOOTER_ONE = -1;
    public static final int SHOOTER_TWO = -1;
    public static final boolean SHOOTER_REVERSE = false;

    public static final int TURRET = 5;
    public static final boolean TURRET_REVERSE = false;
    public static final double TURRET_SPD = 0.25;
    public static final double TURRET_TARGETING_THRESHOLD = 5.0;

    public static final double WHEEL_CIRC = 7.25 * Math.PI;

}