import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
import java.io.InputStream;
//import java.net.URL;
//import java.io.IOException;
import javax.imageio.ImageIO;
//import javax.imageio.stream.ImageInputStream;
import java.awt.Color;
import java.awt.Font;
//import java.io.InputStream;
//import java.awt.Fonte;

public class GeradoraDeFigurinhas {

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
    // leitura da imagem
    // InputStream inputStream=
    // .................new FileInputStream(new File("entrada/filme-maior.jpg"));
    // InputStream inputStream=
    // new
    // URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
    // .openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream); // file pega o endereço da imagem.
    // BufferedImage ImagemOriginal = ImageIO.read(new
    // File("entrada/filme.jpg.jpg"));, tá fixo o nome do arquivo nem sempre precisa
    // ser filme maior,
    // em vez de baixar a imagem receber um endereço.

    // cria nova imagem em memória com transparência e com tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original pra novo imagem(em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // configurar a Fonte
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 72);
    graphics.setFont(fonte);
    graphics.setColor(Color.YELLOW);
    // escrever uma frase na nova imagem
    
    graphics.drawString(" FILMAÇO ", 160, novaAltura - 100);

    // escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
  }
  // public static void main(String[] args) throws Exception {
  // GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
  // geradora.cria();
  // }
}
