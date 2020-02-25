package frc.robot;

import frc.parent.*;
import frc.robot.sensors.LemonLight;

import com.revrobotics.CANSparkMax.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import edu.wpi.first.wpilibj.AnalogPotentiometer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.networktables.NetworkTableType;
// import edu.wpi.first.networktables.NetworkTableValue;

// import com.revrobotics.CANEncoder;

/**
 * Implements the shooter and turret mechanisms
 */
public class Turret implements RobotMap{
    // public AnalogPotentiometer potent = new AnalogPotentiometer(RobotMap.POTENTIOMETER);
    private static CCSparkMax maxTurret = new CCSparkMax(RobotMap.TURRET, MotorType.kBrushless, IdleMode.kBrake, RobotMap.TURRET_REVERSE);
    private static CCSparkMax maxShooter1 = new CCSparkMax(RobotMap.SHOOTER_ONE, MotorType.kBrushless, IdleMode.kCoast, RobotMap.SHOOTER_ONE_REVERSE);
    private static CCSparkMax maxShooter2 = new CCSparkMax(RobotMap.SHOOTER_TWO, MotorType.kBrushless, IdleMode.kCoast, RobotMap.SHOOTER_TWO_REVERSE);

    /**
     * Sets the spin of the turret
     * @param spd Domina: [-1, 1]
     */
    public static void setSpin(double spd){
        if(spd > 0 && !(getEncoder() > 35))
            maxTurret.setSpd(spd);
        else if(spd < 0 && !(getEncoder() < -35))
            maxTurret.setSpd(spd);
        else 
            maxTurret.setSpd(0);
    }

    /**
     * Sets both flywheel speeds
     * @param spd Domain: [-1, 1]
     */
    public static void setShooter(double spd)
    {
        maxShooter1.setSpd(spd);
        maxShooter2.setSpd(spd);
        // System.out.println(maxShooter1.getOutputCurrent());
    }

    /** -+
     * Sets the PID consts for pidController
     * @param Kp P const
     * @param Ki I const
     * @param Kd D const
     * @param Ff Feed forward 
     */
    public static void setConst(double Kp, double Ki, double Kd, double Ff){
        maxTurret.setPID(Kp, Ki, Kd, Ff);
    }
    
    public static double getEncoder(){
        return maxTurret.getPosition();
    }

    public static void reset(){
        maxTurret.setPosition(0);
    }

    public static void restrictTurret(){
    }

    /**
     * Locks on to the target when LemonLight is active
     */
    public static void lockOn(){
        if(LemonLight.hasTarget())
        {
            double outYaw = OI.normalize(LemonLight.getYaw(), -RobotMap.TURRET_SPD, RobotMap.TURRET_SPD, RobotMap.TURRET_TARGETING_THRESHOLD);
            // System.out.println(outYaw);
            setSpin(outYaw);
        }
        else
        {
            System.out.println("No Target");
            setSpin(0.0);
        }
    }

    /**
     * @return The total current from the shooter motors
     */
    public static double getShooterCurrent()
    {
        return maxShooter1.getOutputCurrent() + maxShooter2.getOutputCurrent();
    }

}
