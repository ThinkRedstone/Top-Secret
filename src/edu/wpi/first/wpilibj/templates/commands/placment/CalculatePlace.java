/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands.placment;

import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author ThinkRedstone
 */
public class CalculatePlace extends CommandBase {
    
    public CalculatePlace() {
        requires(placment);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        placment.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        placment.setX(driveTrain.get()* Math.cos(placment.getAngle()));
        placment.setY(driveTrain.get()*Math.sin(placment.getAngle()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
