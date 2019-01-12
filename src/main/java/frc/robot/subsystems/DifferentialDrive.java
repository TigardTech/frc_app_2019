/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * DifferentialDrive is a Subsystem for controlling a differential drive base
 * powered by wheels. It shouldn't be difficult (or likely even necessary) to
 * port the code over to drive a tread-based drive.
 */
public class DifferentialDrive extends Subsystem {
  // Programmer's Note:
  // Talons have a Follower mode that can be used for multi-motor to single
  // wheel drive.
  // @see com.ctre.phoenix.motorcontrol.can.BaseMotorController.set
  TalonSRX leftDriveMotor = new TalonSRX(RobotMap.LEFT_DRIVE_MOTOR);
  TalonSRX rightDriveMotor = new TalonSRX(RobotMap.RIGHT_DRIVE_MOTOR);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  /**
   * Get the robot to go in a direction. This is less specific control
   * than directControlMotor();
   * 
   * @param percent Percent to propel the robot at. Negative values are backwards.
   * @see directControlMotor
   */
  public void drive(double percent){
    leftDriveMotor.set(ControlMode.PercentOutput, percent);
    rightDriveMotor.set(ControlMode.PercentOutput, percent);
  }

  /**
   * Make the robot turn.
   * 
   * @param percent Percent of speed to turn. [-1, 1]. Positive values indicate clockwise rotation.
   */
  public void turn(double percent){
    leftDriveMotor.set(ControlMode.PercentOutput, percent);
    rightDriveMotor.set(ControlMode.PercentOutput, -percent);
  }

  /**
   * Assert direct control over the motors.
   * 
   * @param percentL Percent of speed to turn left motor at. Negative values are backwards.
   * @param percentR Percent of speed to turn right motor at. Negative values are backwards.
   */
  public void directControlMotor(double percentL, double percentR){
    leftDriveMotor.set(ControlMode.PercentOutput, percentL);
    rightDriveMotor.set(ControlMode.PercentOutput, percentR);
  }
}
