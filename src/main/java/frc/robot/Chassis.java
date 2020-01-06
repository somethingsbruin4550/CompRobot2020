package frc.robot;

import frc.parent.*;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import edu.wpi.first.wpilibj.Encoder;
// import com.kauailabs.navx.frc.AHRS;
// import edu.wpi.first.wpilibj.SPI;
// import edu.wpi.first.wpilibj.Timer;

public class Chassis implements RobotMap{


    public static CCSparkMax backLeft = new CCSparkMax(RobotMap.BACK_LEFT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.BL_REVERSE);
    public static CCSparkMax frontLeft = new CCSparkMax(RobotMap.FORWARD_LEFT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.BL_REVERSE);
    public static CCSparkMax backRight = new CCSparkMax(RobotMap.BACK_RIGHT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.BR_REVERSE);
    public static CCSparkMax frontRight = new CCSparkMax(RobotMap.FORWARD_RIGHT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.FR_REVERSE);


    public static void driveSpd(double lspd, double rspd){
        backLeft.set(lspd);
        frontLeft.set(lspd);
        backRight.set(rspd);
        frontRight.set(rspd);
    }

    public static void driveAxis(double yAxis, double xAxis){
        backLeft.set(OI.normalize((yAxis + xAxis), -1.0, 1.0));
        frontLeft.set(OI.normalize((yAxis + xAxis), -1.0, 1.0));
        backRight.set(OI.normalize((yAxis - xAxis), -1.0, 1.0));
        frontRight.set(OI.normalize((yAxis - xAxis), -1.0, 1.0));
    }


    public static void driveDist(double pos, double Kp, double Ki, double Kd, double Ff){
        backLeft.setPID(Kp, Ki, Kd, Ff);
        frontLeft.setPID(Kp, Ki, Kd, Ff);
        backRight.setPID(Kp, Ki, Kd, Ff);
        frontRight.setPID(Kp, Ki, Kd, Ff);
        backLeft.setPosition(pos);
        frontLeft.setPosition(pos);
        backRight.setPosition(pos);
        frontRight.setPosition(pos);
    }
}