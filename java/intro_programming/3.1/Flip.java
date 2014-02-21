public class Flip
{
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);

        int width = pic.width();
        int height = pic.height();

        Picture flip = new Picture(width, height);

        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height; y++) {
                flip.set(x, y, pic.get(x, height - y - 1));
            }
        }
        flip.show();
    }
}
