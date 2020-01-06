package frc.robot;

import frc.parent.*;

import com.revrobotics.CANSparkMax.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import edu.wpi.first.wpilibj.AnalogPotentiometer;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.networktables.NetworkTableType;
// import edu.wpi.first.networktables.NetworkTableValue;

// import com.revrobotics.CANEncoder;

public class Turret implements RobotMap{

    // public CANEncoder encoder = new CANEncoder(super.tOne);
    // public AnalogPotentiometer potent = new AnalogPotentiometer(RobotMap.POTENTIOMETER);
    private CCSparkMax max;
    private NetworkTableInstance table = NetworkTableInstance.getDefault();
    private NetworkTable cam = table.getTable("chameleon-vision").getSubTable("USB Camera-B4.09.24.1");
    private NetworkTableEntry yaw = cam.getEntry("yaw");

    public Turret(){//int chanOne, MotorType type, IdleMode idle, boolean rOne){
        max = new CCSparkMax(4, MotorType.kBrushed, IdleMode.kBrake, false);
    }

    public void set(double spd){
        max.set(spd);
    }

    public void setConst(double Kp, double Ki, double Kd, double Ff){
        max.setPID(Kp, Ki, Kd, Ff);
    } 

    public void lockOn(){
        double x = yaw.getDouble(0);
        double error = Math.abs(x-0);
        double input = OI.normalize((error*5)/100, 0.2, 0.6);
        boolean exists = cam.getEntry("is_valid").getBoolean(false);
        
        if(exists){
            if(x > 2.0){
                // input = input;
            } else if(x < 2.0){
                input = -input;
            } else{
                input = 0; 
            }
        } else {
            input = 0; 
        }

        set(input);

    }

}
