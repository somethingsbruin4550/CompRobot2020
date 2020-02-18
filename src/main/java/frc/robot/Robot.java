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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// import java.util.ResourceBundle.Control;

// import com.revrobotics.CANSparkMax.IdleMode;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DriverStation;

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
  private static final String kResetPIDs = "Reset PIDs";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  // private CCSparkMax fly = new CCSparkMax(2, MotorType.kBrushless, IdleMode.kBrake, false);
  // private CCSparkMax turret = new CCSparkMax(1, MotorType.kBrushless, IdleMode.kBrake, false);
  // private Turret turret = new Turret();

  ReleasableButton yButton;

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
        Chassis.setDistance(3.5 * 12.0, 0.3);
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
    


  }

  @Override
  public void teleopInit() {
    Chassis.resetAll();
    LemonLight.setLight(true);

    OI.initJoysticks();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //Basic Driving
    Chassis.driveAxis(OI.axis(1, PilotMap.Y_AXIS), OI.axis(2, PilotMap.X_AXIS));
    Chassis.drive();
    //Shifting Gearbox Control
    Chassis.setFastMode(OI.button(2, PilotMap.TRIGGER));

    //Extends Intake, if extended, spin
    Intake.setExtended(yButton.updateButton(OI.button(3, ControlMap.Y_BUTTON), 0.5));
    if(yButton.getStatus() && OI.button(3, ControlMap.A_BUTTON))
    {
      Intake.setSpd(OI.normalize(1.0, -0.5, 0.5, 0.15));
    }
    else
    {
      Intake.setSpd(0.0);
    }

    Turret.setShooter(OI.normalize(ControlMap.RT, 0, 1.0, 0.1));
    if(OI.normalize(ControlMap.RT, 0, 1.0, 0.1) > 0.0)
    {
      Loader.setLoaderSpd(1.0);
    }

    if(OI.axis(3, ControlMap.LT) > 0.3)
    {
      Turret.lockOn();
    }
    else
    {
      Turret.setSpin(OI.normalize(OI.axis(3, ControlMap.L_JOYSTICK_HORIZONTAL), -0.5, 0.5, 0.1));
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

  }

  private void resetAll()
  {
    Chassis.resetAll();
  }
}