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
    private static CCSparkMax maxShooter1 = new CCSparkMax(RobotMap.SHOOTER_ONE, MotorType.kBrushless, IdleMode.kBrake, RobotMap.SHOOTER_ONE_REVERSE);
    private static CCSparkMax maxShooter2 = new CCSparkMax(RobotMap.SHOOTER_TWO, MotorType.kBrushless, IdleMode.kBrake, RobotMap.SHOOTER_TWO_REVERSE);

    public static void setSpin(double spd){
        maxTurret.setSpd(spd);
    }

    public static void setShooter(double spd)
    {
        maxShooter1.setSpd(spd);
        maxShooter2.setSpd(-spd);
    }

    public static void setConst(double Kp, double Ki, double Kd, double Ff){
        maxTurret.setPID(Kp, Ki, Kd, Ff);
    } 

    public static void lockOn(){
        if(LemonLight.hasTarget())
        {
            double outYaw = OI.normalize(LemonLight.getYaw(), -RobotMap.TURRET_SPD, RobotMap.TURRET_SPD, RobotMap.TURRET_TARGETING_THRESHOLD);
            System.out.println(outYaw);
            setSpin(outYaw);
        }
        else
        {
            System.out.println("No Target");
            setSpin(0.0);
        }
    }

}
