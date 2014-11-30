/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author ThinkRedstone
 */
public class PlacmentSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Gyro gyro;

    public PlacmentSystem(Gyro gyro) {
        this.gyro = gyro;
        gyro.reset();
    }

    public PlacmentSystem(int gyroPort) {
        this(new Gyro(gyroPort));
    }
    
    public double getAngle(){
        return gyro.getAngle();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
