package frc.robot;

import frc.parent.*;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.Encoder;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
//import edu.wpi.first.wpilibj.Timer;

public class Chassis implements RobotMap{

    public static AHRS gyro = new AHRS(SPI.Port.kMXP);

    public static ShiftDrive driveRight = new ShiftDrive(1, 2, false, false, 0, 1);
    public static ShiftDrive driveLeft = new ShiftDrive(3,4, false, false, 2, 3 ); 

    public static double leftSpd = 0;
    public static double rightSpd = 0; 

    public static void drive(){
        driveRight.setSpd(rightSpd);
        driveLeft.setSpd(leftSpd);    
    }

    public static void driveSpd(double lspd, double rspd)
    {
        leftSpd = lspd;
        rightSpd = rspd; 
    }

    public static void driveAxis(double yAxis, double xAxis){
        leftSpd = OI.normalize((yAxis + xAxis), -1.0, 1.0);
        rightSpd = OI.normalize((yAxis - xAxis), -1.0, 1.0);
    }

    public static void setPID(double Kp, double Ki, double Kd, double Ff){
        driveRight.setPID(Kp, Ki, Kd, Ff);
        driveLeft.setPID(Kp, Ki, Kd, Ff);
    }

    public static void setPosition(double pos){
        driveLeft.setPosition(pos);
        driveRight.setPosition(pos);
    }

    public static void setAngle(double angle){
        driveLeft.setAngle(angle);
        driveRight.setAngle(-angle);
    }
}