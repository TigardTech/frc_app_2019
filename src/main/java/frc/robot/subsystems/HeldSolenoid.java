/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.commands.CloseSolenoid;

/**
 * Subtype of Solenoid that is controlled by held buttons rather than toggled.
 */
public class HeldSolenoid extends GenericSolenoid {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public HeldSolenoid(int solID){
      super(solID);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new CloseSolenoid(this));
  }
}
