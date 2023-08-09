import java.awt.Color;

public class Editor4 {

    public static void main(String[] args) {
        String filename = args[0];
        int steps = Integer.parseInt(args[1]);
        Color[][] image = Instush.read(filename);
        Color[][] imageGrey = Instush.greyscaled(image);
        Instush.morph(image, imageGrey, steps);
    }

}



