package LearnAboutInterfaces;

public class NewZealandTrafficControlSystem implements TrafficControlSystem, ContinentalTrafficControlSystem{
    public void goGreen() {
        System.out.println("Go for 30 seconds");
    }

    public void stopRed() {
        System.out.println("Wait for 1 minute");
    }

    public void slowDownYellow() {
        System.out.println("Slow down in 10 sec");
    }

    public void cycleGreen() {
        System.out.println("Cycle's only go for 20 seconds");
    }
}
