/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.OpenSolenoid;
import frc.robot.commands.StopLift;

/**
 * Elevator lift carrying the ejector.
 */
public class Lift extends Subsystem {

    WPI_TalonSRX liftMotor = new WPI_TalonSRX(RobotMap.LIFT_MOTOR);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new StopLift());
    liftMotor.setInverted(true);
  }

  public void rotateMotor(double theSPEED) {
      liftMotor.set(ControlMode.PercentOutput, theSPEED);
      // ensure that the intake is down when we move this because engineers
      // can find any way to turn a hardware/design issue into a software
      // problem.
      if(!Robot.intakeSol.getState()){
          Scheduler.getInstance().add(new OpenSolenoid(Robot.intakeSol));
      }
  }

  public void stopMotor() {
      liftMotor.set(ControlMode.PercentOutput, 0);
  }
}
