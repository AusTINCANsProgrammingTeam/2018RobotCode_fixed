package frc.team2158.robot.subsystem.lift;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2158.robot.command.lift.StopLift;

import java.util.logging.Logger;

public class LiftSubsystem extends Subsystem {
    private static final Logger LOGGER = Logger.getLogger(LiftSubsystem.class.getName());

    public enum Direction {UP, DOWN}

    private SpeedController liftSpeedController;
    public static double DEFAULT_LIFT_UP_SPEED = 1.0;
    public static double DEFAULT_LIFT_DOWN_SPEED = 0.75;

    public LiftSubsystem(SpeedController liftSpeedController, boolean inverted) {
        this.liftSpeedController = liftSpeedController;
        liftSpeedController.setInverted(inverted);
        LOGGER.info("Lift subsystem initialization complete!");
    }

    public void moveLift(Direction direction, double speed) {
        switch(direction) {
            case UP:
                liftSpeedController.set(speed);
                break;
            case DOWN:
                liftSpeedController.set(-speed);
                break;
        }
    }

    public void stopLift() {
        liftSpeedController.set(0.0);
    }
    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new StopLift());
    }
}
