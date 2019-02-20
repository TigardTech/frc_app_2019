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
 * Add your docs here.
 */
public class EjectorControlledSpin extends InstantCommand {
    private boolean forward;

  /**
   * Add your docs here.
   */
  public EjectorControlledSpin(boolean forward) {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.ejector);
    this.forward = forward;
    this.setInterruptible(true);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
      Robot.ejector.controlledSpin(forward);
  }

}
