package downloadtasks;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class DownloadImage {
    public void downloadImageFromLink(String url, String path) throws IOException {

        URL link = new URL(url);

        // read the url
        BufferedImage image = ImageIO.read(link);

        //for png
        //ImageIO.write(image, "png",new File("/tmp/have_a_question.png"));

        // for jpg
        ImageIO.write(image, "jpg", new File(path));


    }
}
