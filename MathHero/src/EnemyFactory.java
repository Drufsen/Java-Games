public class EnemyFactory {
    private ColorProvider colorProvider;

    public EnemyFactory(ColorProvider colorProvider) {
        this.colorProvider = colorProvider;
    }

    public Enemy createAddition() {
        return new Addition(colorProvider.getAdditionColor());
    }

    public Enemy createBigAddition() {
        return new BigAddition(colorProvider.getBigAdditionColor());
    }

    public Enemy createSubtraction() {
        return new Subtraction(colorProvider.getSubtractionColor());
    }

    public Enemy createMultiplication() {
        return new Multiplication(colorProvider.getMultiplicationColor());
    }

    public Enemy createBigMultiplication() {
        return new BigMultiplication(colorProvider.getBigMultiplicationColor());
    }

    public Enemy createDivision() {
        return new Division(colorProvider.getDivisionColor());
    }
}
