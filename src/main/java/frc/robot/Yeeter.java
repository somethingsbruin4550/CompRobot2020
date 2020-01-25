package frc.robot;

import frc.parent.*;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Yeeter{

    private static CCSparkMax max1 = new CCSparkMax(RobotMap.YEETER_ONE, MotorType.kBrushless, IdleMode.kBrake, false);
    private static CCSparkMax max2 = new CCSparkMax(RobotMap.YEETER_TWO, MotorType.kBrushless, IdleMode.kBrake, false);

    public void set(double spd){
        max1.set(spd);
        max2.set(-spd);
    }
}