package regression.Pages;

public class Checkout {
    private int runningTotalBanana;

    public void addBanana(int count, int price) {
        runningTotalBanana += (count * price);
    }

    public int total() {
        return runningTotalBanana;
    }
}
