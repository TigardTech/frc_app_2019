/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class EjectorInSlow extends CommandGroup {
  /**
   * Pull the ball through the ejector chute slow-like;
   */
  public EjectorInSlow() {
      if(Robot.ejector.getEjectorSpeed() != 0.4) {
        addSequential(new SetEjectorSpeed(0.4));
      }
      addSequential(new EjectorControlledSpin(false));
  }
}
