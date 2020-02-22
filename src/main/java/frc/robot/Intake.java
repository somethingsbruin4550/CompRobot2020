package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import frc.parent.*;

/**
 * This class acts as the main controller for the intake
 * Because there is only one intake, this class is static.
 * the class should NOT have an instance of it
 */

public class Intake implements RobotMap
{
    public static CCSparkMax max = new CCSparkMax(RobotMap.INTAKE, MotorType.kBrushed, IdleMode.kBrake, RobotMap.INTAKE_REVERSE);
    //public static Solenoid sol = new Solenoid(RobotMap.INTAKE_SOLENDOID);

    /**
     * @param extended If true, pnumatics will extend. 
     * This method is to extend the intake in and out of the frame perimeter
     */
    public static void setExtended(boolean extended)
    {
     //   sol.set(extended);
        // max.disable();
    }

    /**
     * @param spd Sets the spd of the intake wheels. Domain: [-1, 1]
     */
    public static void setSpd(double spd)
    {
        max.setSpd(spd);
    }
}