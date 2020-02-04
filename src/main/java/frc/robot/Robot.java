/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

// import java.sql.Driver;

// import com.revrobotics.ControlType;
// import com.revrobotics.CANSparkMax.IdleMode;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
// import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj.Solenoid;

// import com.revrobotics.ControlType;
// import com.revrobotics.CANSparkMax.IdleMode;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.parent.PilotMap;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  // private CCSparkMax max;
  // private CCSparkMax one;
  // private CCSparkMax two;
  private Compressor compressor;
  private ShiftDrive drive1;


  //Turret turret = new Turret();//4, MotorType.kBrushed, IdleMode.kBrake, false);
  // Yeeter yeeter = new Yeeter(3, 2, false, false, MotorType.kBrushed, IdleMode.kBrake);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    // Shooter.start();
    compressor = new Compressor(0);
    compressor.start();
    drive1 = new ShiftDrive(1, 2, false, false, 0, 1);

    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    // int alliance;

    // one = new CCSparkMax(1, MotorType.kBrushless, IdleMode.kBrake, false);
    // two = new CCSparkMax(2, MotorType.kBrushless, IdleMode.kBrake, false);
    
    // switch(DriverStation.getInstance().getAlliance()){
    //   case Blue:
    //     alliance = 1;
    //   break;

    //   case Red:
    //     alliance = 0; 
    //   break;
      
    //   case Invalid:
    //     alliance = -1;
    //   break;
    // }

    // Shooter.start();
    // int device = 4;
    // System.out.println("about to instantiate max...");
    // max = new CCSparkMax(device, MotorType.kBrushless, IdleMode.kBrake, false );

    // max.setPID(0.05, 0.0, 0.0, 0.0);
    // set the speed
    // max.set(0.0);

    // System.out.println("method roboInit() exit");
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
    compressor.start();
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
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);


// turn the wheel
    // double pos = max.getPosition();
    // System.out.println("position is " + pos);
    // max.setPosition(0.0);
    // max.pidController.setReference(1.0, ControlType.kPosition);
    // System.out.println("position after move is " + max.getPosition());
    

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    // double xaxis = OI.axis(PilotMap.X_AXIS);
    // double yaxis = OI.axis(PilotMap.Y_AXIS);
    // System.out.println("x: " + xaxis + ",y:" + yaxis);
    // Double pos = null;
    // if (yaxis > 0.5) {
    //   // max.setPosition(0.0);
    //   pos = max.getPosition();
    //   max.pidController.setReference(pos+1.0, ControlType.kPosition);
    // }
    // if (yaxis < -0.5) {
    //   // max.setPosition(0.0);
    //   pos = max.getPosition();
    //   max.pidController.setReference(pos-1.0, ControlType.kPosition);
    // }
    // if (pos != null) {
    //   System.out.println("pos: " + pos);
    // }
    // for (int i=0; i < 20; i++)  {
    //   if (OI.button(i)) {
    //     System.out.println("button " + i + " was pressed");
    //   }
    // }
    // if(!OI.button(PilotMap.STICK_BACK))
      // one.set(OI.normalize(OI.axis(PilotMap.Y_AXIS), -1, 1, 0.05));

      // two.set(OI.normalize(OI.axis(PilotMap.Y_AXIS), -1, 1, 0.05));


    // else 
    //   turret.lockOn();

    // if(OI.button(PilotMap.TRIGGER))
    //   Shooter.shoot(0.01);
    // else if(OI.button(PilotMap.STICK_MID))
    //   Shooter.end();
    drive1.setSpd(OI.normalize(OI.axis(PilotMap.Y_AXIS), -1.0, 1.0));

    if(OI.button(PilotMap.TRIGGER))
    {
      drive1.setFast(true);
    }
    else 
    {
      drive1.setFast(false);
    }
  }

  @Override
  public void disabledInit() {
    compressor.stop();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
