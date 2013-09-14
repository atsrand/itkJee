package util;

import java.io.*;

public class Util {

    private static final String ENCODING_LATIN1 = "ISO-8859-1";
    private static final String ENCODING_UTF_8 = "UTF-8";

    public static String readFileUTF8(File f) {
        return readFileSub(f, ENCODING_UTF_8);
    }

    public static String readFile(File f) {
        return readFileSub(f, ENCODING_LATIN1);
    }

    public static void writeFileUTF8(File f, String content) {
        writeFileSub(f, content, ENCODING_UTF_8);
    }

    private static void writeFileSub(File f, String content, String encoding) {
        try {
            OutputStream out = new FileOutputStream(f);
            Writer w = new BufferedWriter(new OutputStreamWriter(out, encoding));
            w.write(content);
            w.flush();
            w.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readFileSub(File f, String encoding) {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(f.getCanonicalPath()), encoding));
        } catch (Exception e) {
            throw new RuntimeException("can't read file: " + e);
        }

        StringBuilder sb = new StringBuilder();
        String line = null;
        boolean firstLine = true;
        try {
            while ((line = reader.readLine()) != null) {
                if (firstLine == true && ENCODING_UTF_8.equals(encoding)) {
                    line = line.replaceFirst("^\\uFEFF", "");
                }
                if (firstLine == false) {
                    sb.append("\n");
                }
                firstLine = false;

                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("file read error", e);
        } finally {
            close(reader);
        }

        return sb.toString();
    }

    private static void close(BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
