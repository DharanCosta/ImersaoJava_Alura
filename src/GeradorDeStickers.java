import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GeradorDeStickers {

    public void create(InputStream inputStream, String nomeArquivo, Float rating) throws Exception{

        // Leitura da imagem

//        InputStream inputStream = new FileInputStream(new File("Assets/filme.jpg"));
//        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMTY1NTI0ODUyOF5BMl5BanBnXkFtZTgwNTEyNjQ0MDE@.jpg");
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Padronizar o tamanho
        imagemOriginal= resizeImage(imagemOriginal, 750,1200);

        // Cria nova imagem em memória com transparência e com tamanho novo

        int width = imagemOriginal.getWidth();
        int height = imagemOriginal.getHeight();
        int newHeight = height+200;

        BufferedImage novaImagem = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para nova imagem

        Graphics2D graphics = (Graphics2D)novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal,0,0, null);


        // Configurar a fonte
        Font fonte = new Font("Impact", Font.ITALIC, 86);
        Font shadow = new Font("Impact", Font.ITALIC, 92);


        // Escrever uma frase na nova imagem

        if(rating>9) {
//            graphics.setFont(shadow);
//            graphics.setColor(Color.BLACK);
//            graphics.drawString("NOTA: "+rating, 60, newHeight - 94);
            graphics.setFont(fonte);
            graphics.setColor(Color.GREEN.darker());
            graphics.setFont(fonte);
            graphics.drawString("NOTA: "+rating, 70, newHeight - 100);

            BufferedImage aproved = ImageIO.read(new File("Assets/approved300.png"));
//             aproved.getScaledInstance(600, (int) (388/ratio), Image.SCALE_SMOOTH);
            graphics.drawImage(aproved, width-300,newHeight-300, null);

            FontRenderContext fontRenderContext = graphics.getFontRenderContext();
            var textLayout = new TextLayout("NOTA: "+rating, fonte, fontRenderContext);

            Shape outline = textLayout.getOutline(null);
            AffineTransform transform = graphics.getTransform();
            transform.translate(70, newHeight-100);
            graphics.setTransform(transform);

            var outlineStroke = new BasicStroke(60 * 0.054166f);
            graphics.setStroke(outlineStroke);

            graphics.setColor(Color.BLACK);
            graphics.draw(outline);
            graphics.setClip(outline);

        }else{
            //Texto
            graphics.setFont(fonte);
            graphics.setColor(Color.RED.darker());
            graphics.drawString("NOTA: "+rating, 70, newHeight - 100);
            //Sticker
            BufferedImage aproved = ImageIO.read(new File("Assets/failed300.png"));
//             aproved.getScaledInstance(600, (int) (388/ratio), Image.SCALE_SMOOTH);
            graphics.drawImage(aproved, width-300,newHeight-300, null);
            //Borda
            FontRenderContext fontRenderContext = graphics.getFontRenderContext();
            var textLayout = new TextLayout("NOTA: "+rating, fonte, fontRenderContext);

            Shape outline = textLayout.getOutline(null);
            AffineTransform transform = graphics.getTransform();
            transform.translate(70, newHeight-100);
            graphics.setTransform(transform);

            var outlineStroke = new BasicStroke(60 * 0.054166f);
            graphics.setStroke(outlineStroke);
            graphics.setColor(Color.BLACK);
            graphics.draw(outline);
            graphics.setClip(outline);
        }

        // Escrever a nova imagem em um arquivo
        File sticker = new File("output/"+nomeArquivo);
        if(sticker.mkdir())
            ImageIO.write(novaImagem, "png", sticker);

    }

    BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }


}
