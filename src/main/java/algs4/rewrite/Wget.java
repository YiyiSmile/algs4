package algs4.rewrite;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author totian
 * @Date 2019/11/2 22:20
 * @Version 1.0
 * @Description
 */
public class Wget {
    public static void main(String[] args) throws IOException {
        //Prepare the inputStream
        String urlPath = args[0];
        URL url = new URL(urlPath);
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        BufferedInputStream bio = new BufferedInputStream(is);

        //Prepare the output file
        String fileName = urlPath.substring(urlPath.lastIndexOf("/") + 1);
        String filePath = "d:\\" + fileName;
        File outputFile = new File(filePath);
        OutputStream os = new FileOutputStream(outputFile);

        //read and write
        byte[] buffer = new byte[1024];
        int size = 0;
        while((size = bio.read(buffer)) != -1){
            os.write(buffer,0,size);
        }

        BufferedReader bfr = new BufferedReader(new FileReader(outputFile));
        String line = null;
        while((line = bfr.readLine()) != null){
            System.out.println(line);
        }
    }
}
