package frc.sensors;

// import frc.*;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class Lemonlight{

    public static NetworkTableInstance table = NetworkTableInstance.getDefault();
    public static NetworkTable cam = table.getTable("chameleon-vision").getSubTable("USB Camera-B4.09.24.1");
    public static NetworkTableEntry yaw = cam.getEntry("yaw");
    public static NetworkTableEntry is_valid = cam.getEntry("is_valid");

    public double tarX(){
        return cam.getEntry("yaw").getDouble(0);
    }

    public double tarY(){
        return cam.getEntry("pitch").getDouble(0);
    }

    public double tarA(){
        return cam.getEntry("area").getDouble(0);
    }

    public boolean tarExists(){
        return cam.getEntry("is_valid").getBoolean(false);
    }
}