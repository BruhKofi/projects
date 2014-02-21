public class Weather
{
    public static void main(String[] args) {
        StdOut.printf("Temperature: %8.5f", temp(args[0]));
    }

    public static double temp(String zip) {
        In webpage = new In("http://www.wunderground.com/cgi-bin/findweather/getForecast?query=" + zip);
        String text = webpage.readAll();
        int firstLook = text.indexOf("nowTemp");
        int value = text.indexOf("value", firstLook);
        String temp = text.substring(value+7, value+10);
        StdOut.println(temp);
        return Double.parseDouble(temp);
    }
}
