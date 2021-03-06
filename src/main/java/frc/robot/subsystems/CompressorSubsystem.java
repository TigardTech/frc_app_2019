/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Pneumatic compressor.
 */
public class CompressorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Compressor c = new Compressor();
  boolean isStarted = true;
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void compressorOff() {
      c.stop();
      isStarted = false;
  }

  public void compressorOn() {
      c.start();
      isStarted = true;
  }

  public void enable(boolean state) {
    if(state) {
        this.compressorOn();
    } else if (!state) {
        this.compressorOff();
    }
  }
}
