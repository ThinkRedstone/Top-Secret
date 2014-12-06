/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author ThinkRedstone
 */
public class PlacmentPIDCalculator extends Subsystem implements In {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private double destX, destY;
    private double total;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public double get() {
        if (total == 0) {
            total = CommandBase.placment.getDistanceToCord(destX, destY);
            return 0;
        } else {
            return total - CommandBase.placment.getDistanceToCord(destX, destY);
        }
    }
}
