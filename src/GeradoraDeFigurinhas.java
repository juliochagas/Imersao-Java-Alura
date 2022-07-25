import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    


    public void cria() throws Exception  {
        // leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        InputStream inputStream = new URL(
            "https://m.media-amazon.com/images/M/MV5BMzE5MDM1NDktY2I0OC00YWI5LTk2NzUtYjczNDczOWQxYjM0XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_Ratio0.6716_AL_.jpg"
            )
            .openStream();
        BufferedImage ImagemOriginal = ImageIO.read(inputStream);
        
        // cria uma nova imagem com transparencia e tamanho novo
        int largura = ImagemOriginal.getWidth();
        int altura = ImagemOriginal.getHeight();

        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(ImagemOriginal, 0,0,null);

        // Configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOP", 100, novaAltura-100);
        // escrever a imagem nova em um arquivo
        ImageIO.write(novaImagem, "PNG", new File("entrada/figurinha.png"));

    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }
}
