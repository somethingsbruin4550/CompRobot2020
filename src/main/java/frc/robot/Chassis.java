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

    // public static ShiftDrive driveRight = new ShiftDrive(RobotMap.FORWARD_RIGHT, RobotMap.BACK_RIGHT, RobotMap.FR_REVERSE, RobotMap.BR_REVERSE, 0, 1);
    // public static ShiftDrive driveLeft = new ShiftDrive(RobotMap.FORWARD_LEFT,RobotMap.BACK_LEFT, RobotMap.FL_REVERSE, RobotMap.BL_REVERSE, 2, 3 ); 
    public static CCSparkMax FRMax = new CCSparkMax(RobotMap.FORWARD_RIGHT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.FR_REVERSE);

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

    /**
     * Sets the target motor position
     * @param dist The distance in inches
     */
    public static void setDistance(double dist){
        driveLeft.setMaxSpd(0.3);
        driveRight.setMaxSpd(0.3);
        driveLeft.setDistance(-dist/RobotMap.WHEEL_CIRC);
        driveRight.setDistance(-dist/RobotMap.WHEEL_CIRC);
    }

    public static void setPositionConversionFactor(double factor){
        driveLeft.setPositionConversionFactor(factor);
        driveRight.setPositionConversionFactor(factor);
    }

    public static double getAngle()
    {
        return gyro.getAngle();
    }

    public static double getPos()
    {
        return -(driveRight.getPosition() + driveLeft.getPosition())/2;
    }

    public static void resetAll()
    {
        gyro.reset();
        driveLeft.setPosition(0);
        driveRight.setPosition(0);
    }
}