package frc.robot;

import frc.parent.*;

// import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;

public class Elevator implements RobotMap
{
    public static CCSparkMax max1 = new CCSparkMax(RobotMap.CLIMBER_ONE, MotorType.kBrushless, IdleMode.kBrake, RobotMap.CLIMBER_ONE_REVERSE);
    public static CCSparkMax max2 = new CCSparkMax(RobotMap.CLIMBER_TWO, MotorType.kBrushless, IdleMode.kBrake, RobotMap.CLIMBER_TWO_REVERSE);

    public static Solenoid sol = new Solenoid(RobotMap.CLIMBER_SOL);
    
    /**
     * Sets the speed of the elevator motors
     * @param spd Speed of the motors
     */
    public static void setSpd(double spd)
    {
        max1.set(spd);
        max2.set(spd);
    }

    /**
     * @param extended Whether the cylnders should be extended or not
     */
    public static void setExtended(boolean extended)
    {
        sol.set(extended);
    }
}