package frc.robot;

import frc.robot.CCSparkMax;
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

    public void setSpd(double spd)
    {
        max1.set(spd);
        max2.set(spd);
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
}