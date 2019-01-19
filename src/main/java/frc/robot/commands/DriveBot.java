/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class DriveBot extends InstantCommand {
  public DriveBot() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    super();

    requires(Robot.mechDrive);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    // TODO: get rid of this if it doesn't work
    if(Robot.main_stick.getRawButton(1)){
      Robot.mechDrive.drive(0, Robot.main_stick.getY(), Robot.main_stick.getX());
    } else {
      Robot.mechDrive.drive(Robot.main_stick.getX(), Robot.main_stick.getY(), 0);
    }
  }

}
