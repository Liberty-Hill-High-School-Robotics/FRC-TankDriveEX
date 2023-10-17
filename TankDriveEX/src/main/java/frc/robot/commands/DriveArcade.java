package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

//imports
import frc.robot.subsystems.Drive;


public class DriveArcade extends CommandBase {

        private final Drive m_drive;


    public DriveArcade(Drive subsystem) {

        m_drive = subsystem;
        addRequirements(m_drive);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {

        //takes joystick values and outputs them to m_drive.DriveArcade
        if(Math.abs(-RobotContainer.getInstance().getdriverJoystick().getY()) < .1 ){ //deadzone
            m_drive.DriveArcade(-RobotContainer.getInstance().getdriverJoystick().getY(),RobotContainer.getInstance().getdriverJoystick().getX() * 0.5);
        } else {
        m_drive.DriveArcade(-RobotContainer.getInstance().getdriverJoystick().getY(),RobotContainer.getInstance().getdriverJoystick().getX() * 0.5);
        }



    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drive.driveStop();
        //function that stops the drive command
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {

        return false;
        //drive command will always be on
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
        //ignore for default command
    }
}
