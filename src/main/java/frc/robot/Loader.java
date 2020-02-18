package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.parent.*;

/**
 * The magazine ("Spindexer") of the robot and the loader wheel
 */
public class Loader implements RobotMap
{
    public static CCSparkMax spinMax = new CCSparkMax(RobotMap.SPINDEXER, MotorType.kBrushless, IdleMode.kBrake, RobotMap.SPINDEXER_REVERSE);
    public static CCSparkMax loaderMax = new CCSparkMax(RobotMap.LOADER, MotorType.kBrushless, IdleMode.kBrake, RobotMap.LOADER_REVERSE);

    public static void setSpinSpd(double spd)
    {
        spinMax.setSpd(spd);
    }

    public static void setLoaderSpd(double spd)
    {
        loaderMax.setSpd(spd);
    }
}