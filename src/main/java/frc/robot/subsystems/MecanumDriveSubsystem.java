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
  public void drive(double xSpeed, double ySpeed, double zRotation){
    base.driveCartesian(xSpeed, ySpeed, zRotation);
  }

  public void allStop(){
    base.stopMotor();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveFullStop());
  }
}
