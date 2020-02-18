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

public class Turret implements RobotMap{

    // public CANEncoder encoder = new CANEncoder(super.tOne);
    // public AnalogPotentiometer potent = new AnalogPotentiometer(RobotMap.POTENTIOMETER);
    private static CCSparkMax max = new CCSparkMax(RobotMap.TURRET, MotorType.kBrushless, IdleMode.kBrake, RobotMap.TURRET_REVERSE);

    public static void set(double spd){
        max.set(spd);
    }

    public static void setConst(double Kp, double Ki, double Kd, double Ff){
        max.setPID(Kp, Ki, Kd, Ff);
    } 

    public static void lockOn(){
        if(LemonLight.hasTarget())
        {
            double outYaw = OI.normalize(LemonLight.getYaw(), -RobotMap.TURRET_SPD, RobotMap.TURRET_SPD, RobotMap.TURRET_THRESHOLD);
            System.out.println(outYaw);
            set(outYaw);
        }
        else
        {
            System.out.println("No Target");
            set(0.0);
        }
    }

}
