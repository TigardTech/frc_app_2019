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
 * Triggers on any activity outside the 0.2 range from given joystick
 * 
 * note: right now our joystick instance is inside Robot. idk if it matters
 * but it might maybe break something
 * 
 * abandon hope all ye who enter here
 */
public class MainAxisTrigger extends Trigger {

  private Joystick joy;

  public MainAxisTrigger(Joystick joy) {
    this.joy = joy;
  }

  @Override
  public boolean get() {
    final double DEADZONE = 0.15;
    //  || Math.abs(Robot.main_stick.getZ()) > 0.2 used to be tacked on the end
    if(Math.abs(joy.getY()) > DEADZONE || Math.abs(joy.getX()) > DEADZONE){
      return true;
    } else {
      return false;
    }
  }

  /*
  @Override
  public void whileActive(Command cmd){
    cmd.start();
  }
  */
}
