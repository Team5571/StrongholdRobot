// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5571.StrongholdRobot.subsystems;

import org.usfirst.frc5571.StrongholdRobot.RobotMap;
import org.usfirst.frc5571.StrongholdRobot.commands.*;
import org.usfirst.frc5571.StrongholdRobot.Constants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *
 */
public class Shooter extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon leftBoulderWheel = RobotMap.shooterLeftBoulderWheel;
    private final CANTalon rightBoulderWheel = RobotMap.shooterRightBoulderWheel;
    private final CANTalon boulderLoader = RobotMap.shooterBoulderLoader;
    private final CANTalon aimingActuator = RobotMap.shooterAimingActuator;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initShooter() {
    	// Initialize Left Wheel Motor Controller
    	leftBoulderWheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	leftBoulderWheel.setInverted(Constants.SHOOTER_LEFT_WHEEL_INVERTED);
    	leftBoulderWheel.changeControlMode(TalonControlMode.PercentVbus);
    	leftBoulderWheel.reverseSensor(Constants.SHOOTER_LEFT_WHEEL_INVERT_SENSOR);
    	
    	// Initialize Right Wheel Motor Controller
    	rightBoulderWheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	rightBoulderWheel.setInverted(Constants.SHOOTER_RIGHT_WHEEL_INVERTED);
    	rightBoulderWheel.changeControlMode(TalonControlMode.PercentVbus);
    	rightBoulderWheel.reverseSensor(Constants.SHOOTER_RIGHT_WHEEL_INVERT_SENSOR);
    	
    	// Initialize Aiming Linear Actuator
    	aimingActuator.setInverted(Constants.SHOOTER_ANGLE_MOTOR_INVERTED);
    	aimingActuator.setFeedbackDevice(FeedbackDevice.AnalogPot);
    	aimingActuator.reverseSensor(Constants.SHOOTER_ANGLE_POT_INVERTED);
    	aimingActuator.enableBrakeMode(Constants.SHOOTER_ANGLE_BRAKE_ENABLED);
    	aimingActuator.setForwardSoftLimit(Constants.SHOOTER_FORWARD_SOFTLIMIT);
    	aimingActuator.enableForwardSoftLimit(true);
    	aimingActuator.setReverseSoftLimit(Constants.SHOOTER_REVERSE_SOFTLIMIT);
    	aimingActuator.enableReverseSoftLimit(true);
    }

    public void initShooterWheelsVelocityMode() {
    	
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new ShooterAimWithJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setShooterWheelsOpenLoop(double wheelSpeed) {
    	leftBoulderWheel.changeControlMode(TalonControlMode.PercentVbus);
    	rightBoulderWheel.changeControlMode(TalonControlMode.PercentVbus);
    	leftBoulderWheel.set(wheelSpeed);
    	rightBoulderWheel.set(wheelSpeed);
    	return;
    }
    
    
    public void	aimModePercentVBus()
    {
    	aimingActuator.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void aimAtPosition(int aimPosition)
    {
    	aimingActuator.changeControlMode(TalonControlMode.Position);
    	aimingActuator.setProfile(0);
    	aimingActuator.clearIAccum();
    	aimingActuator.set(aimPosition);
    }
    
    public int getAimingError()
    {
    	return aimingActuator.getClosedLoopError();
    }
    
    public void stopAimingActuaor()
    {
    	aimingActuator.changeControlMode(TalonControlMode.PercentVbus);
    	aimingActuator.set(0);
    }
}


