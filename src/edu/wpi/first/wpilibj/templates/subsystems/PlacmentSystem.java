/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.placment.CalculatePlace;

/**
 *
 * @author ThinkRedstone
 */
public class PlacmentSystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Gyro gyro;
    private double x, y;

    public PlacmentSystem(Gyro gyro) {
        this.gyro = gyro;
        gyro.reset();
    }

    public PlacmentSystem(int gyroPort) {
        this(new Gyro(gyroPort));
    }

    public double getAngle() {
        return gyro.getAngle();
    }

    public double getX() {
        return x;
    }

    public void addToX(double x) {
        this.x += x;
    }

    public double getY() {
        return y;
    }

    public void addToY(double y) {
        this.y += y;
    }

    public void reset() {
        x = 0;
        y = 0;
        gyro.reset();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CalculatePlace());
    }
}
