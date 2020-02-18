package frc.robot;

import frc.parent.*;

import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.Encoder;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * The robot chassis
 */
public class Chassis implements RobotMap{

    public static AHRS gyro = new AHRS(SPI.Port.kMXP);

    public static CCSparkMax FRMax = new CCSparkMax(RobotMap.FORWARD_RIGHT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.FR_REVERSE);
    public static CCSparkMax BRMax = new CCSparkMax(RobotMap.BACK_RIGHT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.BR_REVERSE);
    public static CCSparkMax FLMax = new CCSparkMax(RobotMap.FORWARD_LEFT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.FL_REVERSE);
    public static CCSparkMax BLMax = new CCSparkMax(RobotMap.BACK_LEFT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.BL_REVERSE);
    
    public static Solenoid shiftSol = new Solenoid(RobotMap.SHIFT_SOLENOID);

    public static double leftSpd = 0;
    public static double rightSpd = 0; 

    /**
     * Pushes the stored speed values to the motors
     */
    public static void drive(){
        FRMax.setSpd(rightSpd);
        BRMax.setSpd(rightSpd);
        FLMax.setSpd(leftSpd);
        BLMax.setSpd(leftSpd);
    }

    /**
     * Sets the speed of the drive train
     * @param lspd The speed of the left side of the chassis
     * @param rspd The speed of the right side of the chassis
     */
    public static void driveSpd(double lspd, double rspd)
    {
        leftSpd = lspd;
        rightSpd = rspd; 
    }

    /**
     * Sets the stored speed values to controller inputs
     * @param yAxis The controller Y Axis
     * @param xAxis The controller X Axis
     */
    public static void driveAxis(double yAxis, double xAxis){
        leftSpd = OI.normalize((yAxis + xAxis), -1.0, 1.0);
        rightSpd = OI.normalize((yAxis - xAxis), -1.0, 1.0);
    }

    /**
     * Sets the PID Values for all motors
     * @param Kp
     * @param Ki
     * @param Kd
     * @param Ff
     */
    public static void setPID(double Kp, double Ki, double Kd, double Ff){
        FRMax.setPID(Kp, Ki, Kd, Ff);
        BRMax.setPID(Kp, Ki, Kd, Ff);
        FLMax.setPID(Kp, Ki, Kd, Ff);
        BLMax.setPID(Kp, Ki, Kd, Ff);
    }

    /**
     * Sets the target motor position
     * @param dist The distance in inches
     */
    public static void setDistance(double dist, double maxSpd){
        FRMax.setMaxSpd(-maxSpd, maxSpd);
        BRMax.setMaxSpd(-maxSpd, maxSpd);
        FLMax.setMaxSpd(-maxSpd, maxSpd);
        BLMax.setMaxSpd(-maxSpd, maxSpd);
        FRMax.setDistance(-dist/RobotMap.WHEEL_CIRC, ControlType.kPosition);
        BRMax.setDistance(-dist/RobotMap.WHEEL_CIRC, ControlType.kPosition);
        FLMax.setDistance(-dist/RobotMap.WHEEL_CIRC, ControlType.kPosition);
        BLMax.setDistance(-dist/RobotMap.WHEEL_CIRC, ControlType.kPosition);
        FRMax.setMaxSpd(-1.0, 1.0);
        BRMax.setMaxSpd(-1.0, 1.0);
        FLMax.setMaxSpd(-1.0, 1.0);
        BLMax.setMaxSpd(-1.0, 1.0);
    }

    /**
     * Sets the Position Conversion factor of all drive motors
     * @param factor The Position Conversion Factor
     */
    public static void setPositionConversionFactor(double factor){
        FRMax.setPositionConversionFactor(factor);
        BRMax.setPositionConversionFactor(factor);
        FLMax.setPositionConversionFactor(factor);
        BLMax.setPositionConversionFactor(factor);
    }

    /**
     * Shifts the gearboxes
     * @param enable Whether the gearboxes should be in fast mode
     */
    public static void setFastMode(boolean fastMode)
    {
        shiftSol.set(fastMode);
        if(fastMode)
        {
            FRMax.setPositionConversionFactor(0.1090909090909090);
            BRMax.setPositionConversionFactor(0.1090909090909090);
            FLMax.setPositionConversionFactor(0.1090909090909090);
            BLMax.setPositionConversionFactor(0.1090909090909090);
        }
        else
        {
            FRMax.setPositionConversionFactor(0.048);
            BRMax.setPositionConversionFactor(0.048);
            FLMax.setPositionConversionFactor(0.048);
            BLMax.setPositionConversionFactor(0.048);
        }

        FRMax.setPosition(0);
        BRMax.setPosition(0);
        FLMax.setPosition(0);
        BLMax.setPosition(0);
        
    }

    /**
     * Gets the angle of the gyro
     */
    public static double getAngle()
    {
        return gyro.getAngle();
    }

    /**
     * Gets the average position of all wheel encoders
     */
    public static double getPos()
    {
        return (FRMax.getPosition() + BRMax.getPosition() + FLMax.getPosition() + BLMax.getPosition())/4;
    }

    /**
     * Resets the positions of all motors and the gyro
     */
    public static void resetAll()
    {
        gyro.reset();
        FRMax.setPosition(0);
        BRMax.setPosition(0);
        FLMax.setPosition(0);
        BLMax.setPosition(0);
    }

    /**
     * Disables all chassis motors
     */
    public static void disableAll()
    {
        FRMax.disable();
        BRMax.disable();
        FLMax.disable();
        BLMax.disable();
    }
}