package nz.co.automation.regression.io.random;

public class RandomValueGeneratorFactory {
    public RandomValueGenerator create() {
        return new DefaultRandomValueGenerator();
    }
}
