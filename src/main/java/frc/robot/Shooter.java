package frc.robot;
//imports solenoid timer and compresser from frc
//imports robot map from parent
import edu.wpi.first.wpilibj.Solenoid;
import frc.parent.RobotMap;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Compressor;

public class Shooter{
    //declares and inits shooter object
    //declares and inits compresser object
    private static Solenoid shooter = new Solenoid(RobotMap.PCM_CAN, RobotMap.PCM_SOLENOID);
    private static Compressor compressor = new Compressor(RobotMap.PCM_CAN);
    /**
     * starts compressor
    */
    public static void start(){
        compressor.start();

    }
    /**
     * ends compressor
     */
    public static void end(){
        compressor.stop();
    }
    /**
     *
     * @param delay time in seconds in which the solenoid is open
     */
    public static void shoot(double delay){
            shooter.set(true);
            Timer.delay(delay);
            shooter.set(false);
    }
    
    
}