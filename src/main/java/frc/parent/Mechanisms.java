package frc.parent;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import frc.robot.*;

//This is the general parent class for all the mechanisms of the robot
//If you are building a new mechanism, please dont rewrite old code
public abstract class Mechanisms{

    //Creates talon objects
    //Protected is eaiser to use then making getter and setter methods
    protected CCSparkMax tOne;
    protected CCSparkMax tTwo;
    
    //Builds the two talon objects
    //If a mechaism only has one motor controller, do this:
    //  super(portOne, reverse, -1, false)
    public Mechanisms(int portOne, MotorType contOne, IdleMode idleOne, boolean reverOne, int portTwo, MotorType contTwo, IdleMode idleTwo, boolean reverTwo){
        tOne = new CCSparkMax(portOne, contOne, idleOne, reverOne);
        tTwo = new CCSparkMax(portTwo, contTwo, idleTwo, reverTwo);
    }

    //Sets the motors to a percent output [-100%, 100%]
    //If you only use one talon, ONLY SET ONE TALON
    public abstract void set(double speed);
}