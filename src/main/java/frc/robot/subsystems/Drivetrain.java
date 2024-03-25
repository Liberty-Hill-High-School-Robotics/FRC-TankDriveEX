package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  DifferentialDrive m_drivetrain;

  private CANSparkMax leftFront;
  private CANSparkMax leftRear;
  private CANSparkMax rightFront;
  private CANSparkMax rightRear;

  public Drivetrain() {

    leftFront = new CANSparkMax(kLeftFrontID, MotorType.kBrushless);
    leftFront.setSmartCurrentLimit(kCurrentLimit);
    leftRear = new CANSparkMax(kLeftRearID, MotorType.kBrushless);
    leftRear.setSmartCurrentLimit(kCurrentLimit);
    rightFront = new CANSparkMax(kRightFrontID, MotorType.kBrushless);
    rightFront.setSmartCurrentLimit(kCurrentLimit);
    rightRear = new CANSparkMax(kRightRearID, MotorType.kBrushless);
    rightRear.setSmartCurrentLimit(kCurrentLimit);

    leftFront.setInverted(true);
    rightFront.setInverted(false);

    rightRear.follow(rightFront, false);
    leftRear.follow(leftFront, false);

    m_drivetrain = new DifferentialDrive(leftFront, rightFront);
  }

  public void driveArcade(double speed, double rotation) {
    m_drivetrain.arcadeDrive(speed, rotation);
  }

  public void driveBack(double speed) {
    rightFront.set(speed);
    leftFront.set(speed);
  }

  public void stop() {
    rightFront.stopMotor();
    leftFront.stopMotor();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("LeftBackTemp", leftRear.getMotorTemperature());
    SmartDashboard.putNumber("RightBackTemp", rightFront.getMotorTemperature());
    SmartDashboard.putNumber("LeftFrontTemp", leftFront.getMotorTemperature());
    SmartDashboard.putNumber("RightFrontTemp", rightFront.getMotorTemperature());

    SmartDashboard.putNumber("LBMotorVoltage", leftRear.getBusVoltage());
    SmartDashboard.putNumber("LFMotorVoltage", leftFront.getBusVoltage());
    SmartDashboard.putNumber("RBMotorVoltage", rightRear.getBusVoltage());
    SmartDashboard.putNumber("RFMotorVoltage", rightFront.getBusVoltage());
  }
}
