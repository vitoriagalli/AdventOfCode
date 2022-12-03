package days;


public class Day08 extends AbstractDay {

    private String image;
    private int width;
    private int height;
    private int nLayers;

    public Day08() {
        super("08");
        width = 25;
        height = 6;
    }

    @Override
    public void part1() {
        System.out.println("Part1:");
        System.out.println(solvePart1());
    }

    @Override
    public void part2() {
        System.out.println("Part2:");
        System.out.println(solvePart2());
    }

    public int solvePart1() {
        image = argList.get(0);
        nLayers = image.length()/width/height;
        String layerWithLeastZeros = getLayerWithLeastZeros(image);

        return (int) (layerWithLeastZeros.chars().filter(num -> num == '1').count()
                        * layerWithLeastZeros.chars().filter(num -> num == '2').count());
    }

    public String solvePart2() {

        String finalImage = getFinalImage(image);
        for (int i = 0; i < height; i++) {
            System.out.println(finalImage.substring(i * width,  Math.min((i + 1) * width, finalImage.length()))
            .replace("1", "█").replace("0", " "));
        }

        return finalImage;
    }

    private String getFinalImage(String image) {

        String resultString = "";

        int imageLenght = (int)(width * height);

        for (int i = 0; i < imageLenght; i++) {

            for (int j = 0; j < nLayers; j++) {

                char c = image.charAt(j * imageLenght + i);
                if (c != '2') {
                    resultString += c;
                    break;
                }
            }
        }
        return resultString;
    }

    private String getLayerWithLeastZeros(String image) {

        long tmp = width * height;
        String targetLayer = "";
        String layerChars;

        for (int j = 0; j < nLayers; j++) {

            layerChars = image.substring(j * (width * height), j * (width * height) + (width * height));
            long nZeros = layerChars.chars().filter(num -> num == '0').count();

            if (nZeros < tmp) {
                targetLayer = layerChars;
                tmp = nZeros;
            }
        }
        return targetLayer;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
