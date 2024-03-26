package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private WPI_VictorSPX leftFront;
  private WPI_VictorSPX leftRear;
  private DifferentialDrive m_drivetrain;
  private WPI_VictorSPX rightFront;
  private WPI_VictorSPX rightRear;

  public Drivetrain() {

    leftFront = new WPI_VictorSPX(kLeftFrontID);
    leftRear = new WPI_VictorSPX(kLeftRearID);
    rightFront = new WPI_VictorSPX(kRightFrontID);
    rightRear = new WPI_VictorSPX(kRightRearID);

    leftFront.setInverted(true);
    rightFront.setInverted(false);

    rightRear.follow(rightFront);
    leftRear.follow(leftFront);

    m_drivetrain = new DifferentialDrive(leftFront, rightFront);
    m_drivetrain.setSafetyEnabled(true);
    m_drivetrain.setExpiration(0.1);
    m_drivetrain.setMaxOutput(1.0);
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
    SmartDashboard.putNumber("LBMotorVoltage", leftRear.getBusVoltage());
    SmartDashboard.putNumber("LFMotorVoltage", leftFront.getBusVoltage());
    SmartDashboard.putNumber("RBMotorVoltage", rightRear.getBusVoltage());
    SmartDashboard.putNumber("RFMotorVoltage", rightFront.getBusVoltage());
  }
}
