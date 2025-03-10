import java.awt.Color;

public final class ColorProvider {
    private final Color subtractionColor = java.awt.Color.RED;
    private final Color additionColor = java.awt.Color.BLACK;
    private final Color divisionColor = java.awt.Color.RED;
    private final Color multiplicationColor = java.awt.Color.BLACK;
    private final Color bigMultiplicationColor = java.awt.Color.BLACK;
    private final Color bigAdditionColor = java.awt.Color.BLACK;

    public Color getSubtractionColor(){
        return subtractionColor;
    }

    public Color getAdditionColor(){
        return additionColor;
    }

    public Color getDivisionColor(){
        return divisionColor;
    }

    public Color getBigMultiplicationColor(){
        return bigMultiplicationColor;
    }

    public Color getBigAdditionColor(){
        return bigAdditionColor;
    }

    public Color getMultiplicationColor(){
        return multiplicationColor;
    }
}
