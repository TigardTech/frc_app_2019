/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.EjectorFullStop;

/**
 * On-elevator ball collector-ejector. He collect, he eject.
 */
public class Ejector extends Subsystem {
    WPI_TalonSRX ejectorOne = new WPI_TalonSRX(RobotMap.BALL_EJECTOR_ONE);
    WPI_VictorSPX ejectorTwo = new WPI_VictorSPX(RobotMap.BALL_EJECTOR_TWO);

    // speed factor for the ejector. multiply this by direction.
    private double ejectorSpeed = 0.5;

    /**
     * Spin the motor(s) attached to the ejector.
     * 
     * @param quickness spin speed from [-1, 1].
     */
    public void spin(double quickness) {
        ejectorOne.set(ControlMode.PercentOutput, quickness);
        ejectorTwo.set(ControlMode.PercentOutput, quickness);
    }

    /**
    * tell the motors to do absolutely nothing
    */
    public void stop() {
        final double ADVANCED_NOTHING = 0;
        ejectorOne.set(ControlMode.PercentOutput, ADVANCED_NOTHING);
        ejectorTwo.set(ControlMode.PercentOutput, ADVANCED_NOTHING);
    }

    /**
     * Control the motor at a set speed. For digital controls that change
     * during usage.
     * 
     * @param forward Is the motor going forward?
     */
    public void controlledSpin(boolean forward) {
        if(forward) {
            this.spin(ejectorSpeed);
        } else {
            this.spin(ejectorSpeed * -1.0f);
        }
    }

    /**
     * Change the current controlled speed of the ejector.
     */
    public void setEjectorSpeed(double ejectorSpeed) {
        this.ejectorSpeed = Math.abs(ejectorSpeed);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new EjectorFullStop());
    }

    public double dbgGetEjectorSpeed() {
        return this.ejectorSpeed;
    }
}