package frc.team2158.robot.command.intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;

import java.util.logging.Logger;

public class StopIntakeAndPivot extends Command {
    private static final Logger LOGGER = Logger.getLogger(StopIntakeAndPivot.class.getName());


    public StopIntakeAndPivot() {
        requires(Robot.getIntakeSubsystem());
    }


    @Override
    protected void initialize() {
        Robot.getIntakeSubsystem().stopPivot();
        Robot.getIntakeSubsystem().stopIntake();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
