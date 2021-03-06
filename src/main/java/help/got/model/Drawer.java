package help.got.model;

import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;

@Getter
public class Drawer {

    private BufferedImage image;
    private Graphics2D graphics;

    public Drawer(BufferedImage image, Color color, float stroke) {
        this.image = image;
        this.graphics = image.createGraphics();
        this.graphics.setPaint(color);
        this.graphics.setStroke(new BasicStroke(stroke));
    }

    public void drawPoint(int x, int y, int size) {
        graphics.drawOval(x, y, size, size);
    }

    public void saveFile(Path path) throws IOException {
        ImageIO.write(this.image, "png", path.toFile());
    }

    public void setColor(Color color) {
        this.graphics.setPaint(color);
    }

    public void drawText(String text, int x, int y) {
        graphics.drawString(text, x, y);
    }

    public byte[] getImageAsBytes() throws IOException  {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}



}
