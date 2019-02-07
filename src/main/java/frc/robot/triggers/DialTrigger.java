/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;

import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.Robot;

/**
 * For the old Logitech Joysticks that we have lying
 * around that I've been using for teesting. triggers
 * under similar conditions to MainAxisTrigger, but
 * only for the "Z" axis (the little dial on the
 * front of the stick that the class is named after)
 * 
 * @see frc.robot.triggers.MainAxisTrigger
 */
public class DialTrigger extends Trigger {
  @Override
  public boolean get() {
    if(Robot.main_stick.getZ() > -0.8 && Robot.main_stick.getRawButton(3)) {
      return true;
    } else {
      return false;
    }
  }
}
