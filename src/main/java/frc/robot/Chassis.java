package frc.robot;

import frc.parent.*;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;

public class Chassis implements RobotMap{

    public static AHRS gyro = new AHRS(SPI.Port.kMXP);

    public static CCSparkMax backLeft = new CCSparkMax(RobotMap.BACK_LEFT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.BL_REVERSE);
    public static CCSparkMax frontLeft = new CCSparkMax(RobotMap.FORWARD_LEFT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.BL_REVERSE);
    public static CCSparkMax backRight = new CCSparkMax(RobotMap.BACK_RIGHT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.BR_REVERSE);
    public static CCSparkMax frontRight = new CCSparkMax(RobotMap.FORWARD_RIGHT, MotorType.kBrushless, IdleMode.kBrake, RobotMap.FR_REVERSE);


    public static double leftSpd = 0;
    public static double rightSpd = 0; 

    public static void drive(){
        backLeft.set(leftSpd);
        frontLeft.set(leftSpd);
        backRight.set(rightSpd);
        frontRight.set(rightSpd);
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

    public static void turnToAngle(double goal, double accepError, double debug){
        double angle;
        double error;
        double input;

        while(true){
            angle = gyro.getAngle();
            error = goal - angle;
            input = OI.normalize(error/goal, -1.0, 1.0);

            if(Math.abs(error) > accepError)
                driveSpd(-input, input);
            else {
                driveSpd(0.0, 0.0);
                break;
            }
        }
    }
}