import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MusicDownloader {
    public static void main(String[] args) throws IOException {
        String musicUrl = "https://ruo.morsmusic.org/load/964529964/Ariya_-_Iskushenie_(musmore.com).mp3"; // Замените на URL музыки

        String fileName = "Искушение.mp3";
        String savePath = "C:\\Users\\Пользователь\\Documents\\downloadMusick\\" + fileName;
        downloadMusic(musicUrl, savePath);
    }

    private static void downloadMusic(String musicFileUrl, String savePath) throws IOException {
        URL url = new URL(musicFileUrl);
        URLConnection connection = url.openConnection();
        try (InputStream in = new BufferedInputStream(connection.getInputStream());
             FileOutputStream out = new FileOutputStream(savePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
            }
        }
    }
}
