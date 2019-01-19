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
public class DriveFullStop extends InstantCommand {
  /**
   * Add your docs here.
   */
  public DriveFullStop() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.mechDrive);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.mechDrive.allStop();
    // R E C U R S I O N
    DriveFullStop dfs = new DriveFullStop();
    dfs.start();
    
  }

}
