/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Triggers on any activity outside the 0.2 range on the Z axis from given joystick
 * 
 * modified version of the orignal MainAxisTrigger
 */
public class ZAxisTrigger extends Trigger {

  private Joystick joy;
  private boolean fullRange = false;


  /**
  * Triggers on any activity outside the 0.2 range on the Z axis from given joystick
  * modified version of the orignal MainAxisTrigger
  *
  * can be configured to only deadzone on one end of the stick, basically treating it
  * as if it works in the range [0.0, 2.0] rather than [-1.0, 1.0].
  *
  * @param joy Joystick to use
  * @param full_range Whether or not we should run the joystick with full range
  */
  public ZAxisTrigger(Joystick joy, boolean full_range) {
    this.joy = joy;
    fullRange = full_range;
  }

  @Override
  public boolean get() {
    final double DEADZONE = 0.15;
    if(fullRange){
      if(joy.getZ() > (-1 + DEADZONE)) {
        return true;
      } else {
        return false;
      }
    } else {
      if(Math.abs(joy.getZ()) > DEADZONE){
        return true;
      } else {
        return false;
      }
    }
  }

  /*
  @Override
  public void whileActive(Command cmd){
    cmd.start();
  }
  */
}
