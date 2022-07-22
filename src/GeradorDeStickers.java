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

    public void create(InputStream inputStream, String nomeArquivo, Float rating, String date, String minhaAPI) throws Exception{

        // Leitura da imagem
//        InputStream inputStream = new FileInputStream(new File("Assets/filme.jpg"));
//        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMTY1NTI0ODUyOF5BMl5BanBnXkFtZTgwNTEyNjQ0MDE@.jpg");
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // Padronizar o tamanho
        if(minhaAPI != "LOCAL"){
            if(imagemOriginal.getWidth() == imagemOriginal.getHeight()){
                imagemOriginal = resizeImage(imagemOriginal,500,500);
            }else if(imagemOriginal.getWidth()<imagemOriginal.getHeight()) {
                imagemOriginal = resizeImage(imagemOriginal, 750, 1200);
            }else{
                imagemOriginal = resizeImage(imagemOriginal, 1200, 750);
            }
        }
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

        // Escrever uma frase na nova imagem
        if(minhaAPI == "LOCAL"){
            Font fontLocal = new Font("Impact",Font.ITALIC,45);
            graphics.setFont(fontLocal);
            graphics.setColor(Color.WHITE);
            graphics.setFont(fontLocal);
            if(rating==1){
                graphics.drawString("MEU FAV", 50, newHeight - 150);
            }else {
                graphics.drawString("RANK: " + rating, 50, newHeight - 150);
            }
        }else if(minhaAPI == "NASA"){
            graphics.setFont(fonte);
            graphics.setColor(Color.WHITE);
            graphics.setFont(fonte);
            graphics.drawString("DATA: "+date, 70, newHeight - 100);
            //Adiciona um segundo Sticker - APROVADO
            BufferedImage nasa = ImageIO.read(new File("Assets/nasa300.png"));
            graphics.drawImage(nasa, width-300,newHeight-300, null);
            //Contorno na fonte
            FontRenderContext fontRenderContext = graphics.getFontRenderContext();
            var textLayout = new TextLayout("DATA: "+date, fonte, fontRenderContext);

            Shape outline = textLayout.getOutline(null);
            AffineTransform transform = graphics.getTransform();
            transform.translate(70, newHeight-100);
            graphics.setTransform(transform);

            var outlineStroke = new BasicStroke(60 * 0.054166f);
            graphics.setStroke(outlineStroke);

            graphics.setColor(Color.BLUE.darker().darker());
            graphics.draw(outline);
            graphics.setClip(outline);
        }else if(minhaAPI == "IMDB"){
            if(rating>9) {
                graphics.setFont(fonte);
                graphics.setColor(Color.GREEN.darker());
                graphics.setFont(fonte);
                graphics.drawString("NOTA: "+rating, 70, newHeight - 100);
                //Adiciona um segundo Sticker - APROVADO
                BufferedImage aproved = ImageIO.read(new File("Assets/approved300.png"));
                graphics.drawImage(aproved, width-300,newHeight-300, null);
                //Contorno na fonte
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
