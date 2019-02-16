/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.StopLift;

/**
 * Elevator lift carrying the ejector.
 */
public class Lift extends Subsystem {

    WPI_VictorSPX liftMotor = new WPI_VictorSPX(RobotMap.LIFT_MOTOR);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new StopLift());
    liftMotor.setInverted(true);
  }

  public void rotateMotor(double theSPEED) {
      liftMotor.set(ControlMode.PercentOutput, theSPEED);
  }

  public void stopMotor() {
      liftMotor.set(ControlMode.PercentOutput, 0);
  }
}
