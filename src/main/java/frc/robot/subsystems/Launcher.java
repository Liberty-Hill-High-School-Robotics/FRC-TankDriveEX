package frc.robot.subsystems;

import static frc.robot.Constants.LauncherConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {
  private CANSparkMax launchMotor;
  private CANSparkMax feedMotor;

  public Launcher() {
    launchMotor = new CANSparkMax(kLauncherID, MotorType.kBrushless);
    launchMotor.setSmartCurrentLimit(kLauncherCurrentLimit);
    feedMotor = new CANSparkMax(kFeederID, MotorType.kBrushless);
    feedMotor.setSmartCurrentLimit(kFeedCurrentLimit);
  }

  public void setLaunchWheel(double speed) {
    launchMotor.set(speed);
  }

  public void setFeedWheel(double speed) {
    feedMotor.set(speed);
  }

  public void intake(double Lspeed, double Fspeed) {
    launchMotor.set(Lspeed);
    feedMotor.set(Fspeed);
  }

  public void stop() {
    launchMotor.set(0);
    feedMotor.set(0);
  }
}
