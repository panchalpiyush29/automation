package LearnAboutInterfaces;

public class VictoriaStreetTrafficLight {

    public static void main(String[] args){
        NewZealandTrafficControlSystem vicStreet = new NewZealandTrafficControlSystem();
        vicStreet.stopRed();
        vicStreet.slowDownYellow();
        vicStreet.goGreen();
        vicStreet.cycleGreen();
    }

}
