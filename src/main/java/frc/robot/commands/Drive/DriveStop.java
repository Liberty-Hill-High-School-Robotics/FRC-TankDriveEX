package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriveStop extends Command {
  Drivetrain m_drivetrain;

  public DriveStop(Drivetrain subsystem) {
    m_drivetrain = subsystem;

    addRequirements(m_drivetrain);
  }

  // The initialize method is called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }
}
