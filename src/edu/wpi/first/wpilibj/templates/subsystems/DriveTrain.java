/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import driveComponents.Gearbox;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.drive.TwoJoystickDrive;

/**
 *
 * @author Developer
 */
public class DriveTrain extends Subsystem implements In, Out {

    private Gearbox left, right;
    private Encoder encoderP, encoderS;
    private double wheelDiameter;
    private double distanceTraveled;

    public DriveTrain(Gearbox left, Gearbox right, Encoder encoderP, Encoder EncoderS, double wheelDiameter) {
        this.left = left;
        this.right = right;
        this.encoderP = encoderP;
        this.encoderS = EncoderS;
        this.wheelDiameter = wheelDiameter;
    }

    public DriveTrain(int frontLeftPort, int backLeftPort, int frontRightPort, int backRightPort, int encoderPPort1, int encoderPPort2, int encoderSPort1, int encoderSPort2, double wheelDiameter) {
        this(new Gearbox(frontLeftPort, backLeftPort), new Gearbox(frontRightPort, backRightPort), new Encoder(encoderPPort1, encoderSPort2), new Encoder(encoderSPort1, encoderSPort2), wheelDiameter);
    }

    public void twoJoystickDrive(double leftSpeed, double rightSpeed) {
        left.setSpeed(leftSpeed);
        right.setSpeed(rightSpeed);
    }

    public void straight(double speed) {
        left.setSpeed(speed);
        right.setSpeed(-speed);
    }

    public void rotate(double speed) {
        left.setSpeed(speed);
        right.setSpeed(speed);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new TwoJoystickDrive());
    }

    public double get() {
        double tmp = convertEncoderTicks(encoderS.get() + encoderP.get() / 2) - distanceTraveled;
        distanceTraveled += tmp;
        return tmp;
    }

    public void set(double speed) {
        straight(speed);
    }

    public double convertEncoderTicks(double encoderTicks) {
        return (encoderTicks / RobotMap.ENCODER_TICKS_IN_CYCLE) * (wheelDiameter * Math.PI);
    }

    public void reset() {
        encoderP.reset();
        encoderS.reset();
        distanceTraveled = 0;
    }
}
