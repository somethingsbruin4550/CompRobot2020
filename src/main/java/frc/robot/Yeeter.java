package frc.robot;

import frc.parent.*;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Yeeter extends Mechanisms{

    public Yeeter(int chanOne, int chanTwo, boolean rOne, boolean rTwo, MotorType type, IdleMode idle){
        super(chanOne, type, idle, rOne, chanTwo, type, idle, rTwo);
    }

    public void set(double spd){
        super.tOne.set(spd);
        super.tOne.set(-spd);
    }
}