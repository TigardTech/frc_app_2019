/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class mechTest extends InstantCommand {
  static double DEBUG_SPEED = 0.5;
  int motor;
  public mechTest(int victim) {
    super();

    requires(Robot.mechDrive);
    this.motor = victim;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    switch(motor) {
      case 1:
        Robot.mechDrive.motorDirectFL(DEBUG_SPEED);
        break;
      case 2:
        Robot.mechDrive.motorDirectFR(DEBUG_SPEED);
        break;
      case 3:
        Robot.mechDrive.motorDirectRL(DEBUG_SPEED);
        break;
      case 4:
        Robot.mechDrive.motorDirectRR(DEBUG_SPEED);
        break;
      default:
        System.out.println("something very bad has happened");
    }
  }
}