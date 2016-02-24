// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5571.StrongholdRobot;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainLeftWheels;
    public static CANTalon driveTrainRightWheels;
    public static RobotDrive driveTrainRobotDrive21;
    public static CANTalon shooterLeftBoulderWheel;
    public static CANTalon shooterRightBoulderWheel;
    public static CANTalon shooterBoulderLoader;
    public static CANTalon shooterAimingActuator;
    public static Compressor pneumaticsCompressor;
    public static Solenoid pneumaticsLeftArm;
    public static Solenoid pneumaticsRightArm;
    public static Solenoid pneumaticsLeftGearShift;
    public static Solenoid pneumaticsRightGearShift;
    public static Solenoid pneumaticsBoulderLauncher;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static CANTalon driveTrainLeftWheelsSlave;
    public static CANTalon driveTrainRightWheelsSlave;
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftWheels = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "LeftWheels", driveTrainLeftWheels);
        
        driveTrainRightWheels = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "RightWheels", driveTrainRightWheels);
        
        driveTrainRobotDrive21 = new RobotDrive(driveTrainLeftWheels, driveTrainRightWheels);
        
        driveTrainRobotDrive21.setSafetyEnabled(true);
        driveTrainRobotDrive21.setExpiration(0.1);
        driveTrainRobotDrive21.setSensitivity(0.5);
        driveTrainRobotDrive21.setMaxOutput(1.0);

        shooterLeftBoulderWheel = new CANTalon(5);
        LiveWindow.addActuator("Shooter", "LeftBoulderWheel", shooterLeftBoulderWheel);
        
        shooterRightBoulderWheel = new CANTalon(6);
        LiveWindow.addActuator("Shooter", "RightBoulderWheel", shooterRightBoulderWheel);
        
        shooterBoulderLoader = new CANTalon(8);
        LiveWindow.addActuator("Shooter", "BoulderLoader", shooterBoulderLoader);
        
        shooterAimingActuator = new CANTalon(7);
        LiveWindow.addActuator("Shooter", "AimingActuator", shooterAimingActuator);
        
        pneumaticsCompressor = new Compressor(0);
        
        
        pneumaticsLeftArm = new Solenoid(0, 1);
        LiveWindow.addActuator("Pneumatics", "LeftArm", pneumaticsLeftArm);
        
        pneumaticsRightArm = new Solenoid(0, 2);
        LiveWindow.addActuator("Pneumatics", "RightArm", pneumaticsRightArm);
        
        pneumaticsLeftGearShift = new Solenoid(0, 3);
        LiveWindow.addActuator("Pneumatics", "LeftGearShift", pneumaticsLeftGearShift);
        
        pneumaticsRightGearShift = new Solenoid(0, 5);
        LiveWindow.addActuator("Pneumatics", "RightGearShift", pneumaticsRightGearShift);
        
        pneumaticsBoulderLauncher = new Solenoid(0, 4);
        LiveWindow.addActuator("Pneumatics", "BoulderLauncher", pneumaticsBoulderLauncher);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        driveTrainLeftWheelsSlave = new CANTalon(3);
        LiveWindow.addActuator("driveTrain", "LeftWheelsSlavq", driveTrainLeftWheelsSlave);
        driveTrainLeftWheelsSlave.changeControlMode(TalonControlMode.Follower);
        driveTrainLeftWheelsSlave.set(driveTrainLeftWheels.getDeviceID());
        
        driveTrainRightWheelsSlave = new CANTalon(4);
        LiveWindow.addActuator("driveTrain", "RightWheelsSlave", driveTrainRightWheelsSlave);
        driveTrainRightWheelsSlave.changeControlMode(TalonControlMode.Follower);
        driveTrainRightWheelsSlave.set(driveTrainRightWheels.getDeviceID());
    }
}
