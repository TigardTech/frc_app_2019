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
    if(Robot.main_stick.getRawButton(1)){
      Robot.intake.spin(-Robot.main_stick.getZ());
    } else {
      Robot.intake.spin(Robot.main_stick.getZ());
    }
  }

}
