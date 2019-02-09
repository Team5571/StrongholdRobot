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

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5571.StrongholdRobot.Robot;
import org.usfirst.frc5571.StrongholdRobot.subsystems.Pneumatics;
import org.usfirst.frc5571.StrongholdRobot.Constants;

/**
 *
 */
public class ShootLowGoal extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	Timer kickerTimer;
	Timer spinupTimer;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ShootLowGoal() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.pneumatics);


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	kickerTimer = new Timer();
    	spinupTimer = new Timer();
    	requires(Robot.shooter);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	spinupTimer.reset();
    	spinupTimer.start();
    	kickerTimer.stop();
		kickerTimer.reset();
    	Robot.shooter.setShooterWheelsOpenLoop(Constants.SHOOTER_WHEEL_LOW_SPEED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if ((spinupTimer.get() >= Constants.SHOOTER_WHEEL_SPINUP_DELAY) && (kickerTimer.get() == 0)){
    		spinupTimer.reset();
    		kickerTimer.start();
    		Robot.pneumatics.activateBoulderLauncher();    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (kickerTimer.get() > Constants.BOULDER_KICKER_DELAY_TIME);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.pneumatics.armBoulderLauncher();
    	Robot.shooter.setShooterWheelsOpenLoop(0);
    	kickerTimer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.pneumatics.armBoulderLauncher();
    	Robot.shooter.setShooterWheelsOpenLoop(0);
    	kickerTimer.stop();
    }
}