/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.parent.*;
import frc.robot.sensors.*;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// import java.util.ResourceBundle.Control;

// import com.revrobotics.CANSparkMax.IdleMode;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Compressor;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot implements RobotMap, ControlMap {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private static final String kCrossLine = "Cross Line";
  private static final String kMoveShoot = "Cross Line and Shoot";
  private static final String kResetPIDs = "Reset PIDs";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  Compressor compressor = new Compressor();
  // private CCSparkMax fly = new CCSparkMax(2, MotorType.kBrushless, IdleMode.kBrake, false);
  // private CCSparkMax turret = new CCSparkMax(1, MotorType.kBrushless, IdleMode.kBrake, false);
  // private Turret turret = new Turret();

  private static ReleasableButton yButton = new ReleasableButton();

  int alliance;
  double spdmlt = 1;


  int printCount;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    resetAll();
    
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    m_chooser.addOption("Cross Line", kCrossLine);
    m_chooser.addOption("Cross Line and Shoot", kMoveShoot);
    m_chooser.addOption("Reset PID Values", kResetPIDs);
    SmartDashboard.putData("Auto choices", m_chooser);
    
    LemonLight.setLightChannel(0);

    printCount = 0;
  
    switch(DriverStation.getInstance().getAlliance()){
      case Blue:
        alliance = 1;
      break;

      case Red:
        alliance = 0; 
      break;
      
      case Invalid:
        alliance = -1;
      break;
    }
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    if(printCount > 20)
    {
     // System.out.println("Angle: " + Chassis.getAngle());
    //  System.out.println("Position: " + Chassis.driveLeft.getPosition());
      // System.out.println(LemonLight.getYaw());
      printCount = 0;
    }
    printCount++;

    if(RobotMap.ENABLE_COMPRESSOR)
    {
      compressor.start();
    }
    else
    {
      compressor.stop();
    }

    yButton.tick();

    // System.out.println(Loader.spinMax.getPosition());
      
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    Chassis.resetAll();
    Chassis.setPID(0.5, 0, 0, 0);

    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    

    switch (m_autoSelected) {
      case kCustomAuto:
        // Chassis.setDistance(8.0 * 12.0, 0.5);
        //Chassis.setAngle(5);
        break;
      case kCrossLine:
        Chassis.setTargetDistance(4.0 * 12.0, 0.2);
        break;
      case kMoveShoot:
        Chassis.setTargetDistance(4.0 * 12.0, 0.2);
        Turret.lockOnForTime(3);
        Turret.setShooter(Turret.getShooterSpeedFromDistance());
        Loader.setLoaderSpd(RobotMap.LOADER_FWD_SPEED);
        Loader.spinMax.setPosition(0.0);
        Loader.setSpinSpd(RobotMap.SPINDEXER_SPEED);
        while(Loader.spinMax.getPosition() < 1000.0);
        Loader.setSpinSpd(0.0);
        Loader.setLoaderSpd(RobotMap.LOADER_REV_SPEED);
        Turret.setSpin(0.0);
        Turret.maxShooter1.disable();
        Turret.maxShooter2.disable();
        break;
      case kDefaultAuto:
        break;
      case kResetPIDs:
        break;
      default:
        
        break;
    }

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Turret.setShooter(OI.normalize(0.5, -1, 1));
  }

  @Override
  public void teleopInit() {
    Chassis.resetAll();
    Turret.reset();
    LemonLight.setLight(true);

    OI.initJoysticks();
    Intake.setExtended(false);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    // //Basic Driving
    Chassis.driveAxis(OI.axis(0, PilotMap.Y_AXIS), OI.axis(1, PilotMap.X_AXIS));
   // Chassis.driveAxis(OI.axis(2, ControlMap.L_JOYSTICK_VERTICAL), OI.axis(2, ControlMap.L_JOYSTICK_HORIZONTAL));
    Chassis.drive();
    // //Shifting Gearbox Control
    Chassis.setFastMode(OI.button(0, PilotMap.TRIGGER));
    // Chassis.setFastMode(OI.button(2, ControlMap.B_BUTTON));

    //Extends Intake, if extended, spin
  //  Intake.setExtended(yButton.updateButton(OI.button(2, ControlMap.Y_BUTTON), 25));
  // Intake.setExtended(OI.button(2, ControlMap.Y_BUTTON));
  yButton.updateButton(OI.button(2, ControlMap.Y_BUTTON), 25);
  Intake.setExtended(yButton.getStatus());
  // System.out.println(yButton.updateButton(OI.button(2, ControlMap.Y_BUTTON), 0.5));

   if(OI.axis(2, ControlMap.RT) > 0.05)
   {
    Loader.setLoaderSpd(RobotMap.LOADER_FWD_SPEED);
   } 
   else 
   {
     Loader.setLoaderSpd(RobotMap.LOADER_REV_SPEED);
   }

  //  System.out.println(Turret.getEncoder());

    if(OI.button(2, ControlMap.A_BUTTON))
    {
      Intake.setSpd(RobotMap.INTAKE_SPD);
      Loader.setSpinSpd(RobotMap.SPINDEXER_SPEED);
    }
    else
    {
      Intake.setSpd(0);
    }

    if(OI.button(2, ControlMap.LB_BUTTON))
    {
        Turret.lockOn();
        // Turret.setShooter(OI.normalize(LemonLight.distToTarget() / 10.0, 0.0, 1.0));
    }
    else 
      Turret.setSpin(OI.normalize(OI.axis(2, ControlMap.R_JOYSTICK_HORIZONTAL), -0.3, 0.3));
    
    if(OI.normalize(OI.axis(2, ControlMap.LT), -1, 1) > 0.5)
    {
      // Turret.setShooter(OI.normalize(OI.axis(2, ControlMap.LT), -1.0, 1.0, 0.1));
      // Turret.setShooter(Turret.getShooterSpeedFromDistance());4
      Turret.setShooter(1.0);
      Loader.setSpinSpd(RobotMap.SPINDEXER_SPEED);
    }
    else
    {
      Turret.setShooter(0.0);
      if(!OI.button(2, ControlMap.A_BUTTON) && !OI.button(2, ControlMap.BACK_BUTTON))
      {
        Loader.setSpinSpd(0.0);
      }
    }

    if(OI.button(2, ControlMap.BACK_BUTTON))
    {
      Loader.setSpinSpd(-0.5);
      Turret.setShooter(-0.15);
      Intake.setSpd(-0.4);
    }
  }
  

  @Override
  public void disabledInit() {
    Chassis.disableAll();
    LemonLight.setLight(false);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    LemonLight.setLight(true);
    compressor.start();

  }

  private void resetAll()
  {
    Chassis.resetAll();
    Turret.reset();
    Loader.reset();
  }
}