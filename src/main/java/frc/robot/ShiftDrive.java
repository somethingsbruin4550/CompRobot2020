package frc.robot;

import frc.robot.CCSparkMax;

import com.revrobotics.ControlType;
// import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
// import edu.wpi.first.wpilibj.Timer;

public class ShiftDrive
{
    private CCSparkMax max1;
    private CCSparkMax max2;
    private Solenoid shift1;
    private Solenoid shift2;

    public ShiftDrive(int port1, int port2, boolean rev1, boolean rev2, int solPort1, int solPort2)
    {
        max1 = new CCSparkMax(port1, MotorType.kBrushless, IdleMode.kBrake, rev1);
        max2 = new CCSparkMax(port2, MotorType.kBrushless, IdleMode.kBrake, rev2);
        shift1 = new Solenoid(solPort1);
        shift2 = new Solenoid(solPort2);
    }

    public void setPID(double Kp, double Ki, double Kd, double Ff){
        max1.setPID(Kp, Ki, Kd, Ff);
        max2.setPID(Kp, Ki, Kd, Ff);
    }

    public void setDistance(double dist){
        max1.pidController.setReference(dist, ControlType.kPosition);
        max2.pidController.setReference(dist, ControlType.kPosition);
    }

    public void setPosition(double pos){
        max1.encoder.setPosition(pos);
        max2.encoder.setPosition(pos);
    }

    public double getPosition(){
        return (max1.encoder.getPosition() + max2.encoder.getPosition())/2;
    }

    public void setSpd(double spd)
    {
        max1.set(spd);
        max2.set(spd);
    }

    public void setPositionConversionFactor(double factor){
        max1.setPositionConversionFactor(factor);
        max2.setPositionConversionFactor(factor);
    }


    public void setFast(boolean fast)
    {
        if(fast)
        {
            shift1.set(false);
            shift2.set(true);
        }
        else
        {
            shift1.set(true);
            shift2.set(false);
        }
    }

    public void disableAll()
    {
        max1.disable();
        max2.disable();
    }

    public void setMaxSpd(double spd)
    {
        max1.pidController.setOutputRange(-spd, spd);
        max2.pidController.setOutputRange(-spd, spd);
    }
}