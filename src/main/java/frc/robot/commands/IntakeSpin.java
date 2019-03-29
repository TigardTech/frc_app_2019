/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Rotate the intake based on the Z axis' position.
 */
public class IntakeSpin extends InstantCommand {
    /**
     * Rotate the intake based on the Z axis' position.
     */
    public IntakeSpin() {
        super();
        requires(Robot.intake);
    }

    // Called once when the command executes
    @Override
    protected void initialize() {
        Robot.intake.spin(Robot.lift_stick.getRawAxis(2));
        //System.out.printf("trying to spin at %.2f%n", Robot.main_stick.getRawAxis(3));
    }
}
