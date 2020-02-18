package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
import frc.parent.*;

public class Intake implements RobotMap
{
    public static CCSparkMax max = new CCSparkMax(RobotMap.INTAKE, MotorType.kBrushed, IdleMode.kBrake, RobotMap.INTAKE_REVERSE);
    public static Solenoid sol = new Solenoid(RobotMap.INTAKE_SOLENDOID);

    public static void setExtended(boolean extended)
    {
        sol.set(extended);
        max.disable();
    }

    public static void setSpd(double spd)
    {
        max.setSpd(spd);
    }
}