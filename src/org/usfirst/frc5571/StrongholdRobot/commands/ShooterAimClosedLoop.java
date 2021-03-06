// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5571.StrongholdRobot.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5571.StrongholdRobot.Robot;
import org.usfirst.frc5571.StrongholdRobot.RobotMap;
import org.usfirst.frc5571.StrongholdRobot.Constants;

import java.lang.Math;


/**
 *
 */
public class ShooterAimClosedLoop extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private int m_aimingAngle;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ShooterAimClosedLoop(int aimingAngle) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_aimingAngle = aimingAngle;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.shooter);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.aimAtPosition (m_aimingAngle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        if ( (Math.abs(Robot.shooter.getAimingError())) < Constants.SHOOTER_AIMING_ERROR_THRESHOLD){
//        	Robot.shooter.stopAimingActuaor();
//        	return true;
//        }
//        else {
//        	return false;
//        }
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.stopAimingActuaor();
    }
}
