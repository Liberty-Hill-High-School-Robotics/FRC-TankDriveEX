package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.Drive.DriveBack;
import frc.robot.commands.Drive.DriveStop;
import frc.robot.commands.Intake.LaunchNote;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Launcher;

public class ShootNoteAndMove extends SequentialCommandGroup {

    public ShootNoteAndMove(
            Drivetrain drivetrain,
            Launcher launcher) {

        addCommands(
                new LaunchNote(launcher),
                new DriveBack(drivetrain),
                new WaitCommand(2),
                new DriveStop(drivetrain));
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
