/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * Mecanum Drivebase
 */
public class MecanumDriveSubsystem extends Subsystem {
  WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.FRONT_LEFT_DRIVE_MOTOR);
  WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
  WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotMap.REAR_LEFT_DRIVE_MOTOR);
  WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotMap.REAR_RIGHT_DRIVE_MOTOR);
  MecanumDrive base = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);


  /**
   * stupid wrapper for WPI's mecanum drive
   * 
   * what dummy writes their own robot code anyway
   * @see edu.wpi.first.wpilibj.drive.MecanumDrive
   */
  public void drive(double ySpeed, double xSpeed, double zRotation){
    base.driveCartesian(ySpeed, xSpeed, zRotation);
  }

  /**
   * tell all the motors to stop. this should be the default command
   */
  public void fullStop(){
    frontLeft.set(ControlMode.PercentOutput, 0);
    frontRight.set(ControlMode.PercentOutput, 0);
    rearLeft.set(ControlMode.PercentOutput, 0);
    rearRight.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new FullDriveStop());
  }
}
