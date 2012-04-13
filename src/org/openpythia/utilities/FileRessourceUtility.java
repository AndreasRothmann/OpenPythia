package org.openpythia.utilities;

import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import javax.swing.JOptionPane;

public class FileRessourceUtility {

    private static FileRessourceUtility privateInstance = new FileRessourceUtility();

    private FileRessourceUtility() {
    }

    private static String replaceSpecialCharacters(String input) {
        String stringx = input;

        stringx = stringx.replace("%20", " ");
        stringx = stringx.replace("%c2%a1", "�");
        stringx = stringx.replace("%c2%a2", "�");
        stringx = stringx.replace("%c2%a3", "�");
        stringx = stringx.replace("%c2%a4", "�");
        stringx = stringx.replace("%c2%a5", "�");
        stringx = stringx.replace("%c2%a6", "�");
        stringx = stringx.replace("%c2%a7", "�");
        stringx = stringx.replace("%c2%a8", "�");
        stringx = stringx.replace("%c2%a9", "�");
        stringx = stringx.replace("%c2%aa", "�");
        stringx = stringx.replace("%c2%ab", "�");
        stringx = stringx.replace("%c2%ac", "�");
        stringx = stringx.replace("%c2%ad", "�");
        stringx = stringx.replace("%c2%ae", "�");
        stringx = stringx.replace("%c2%af", "�");
        stringx = stringx.replace("%c2%b0", "�");
        stringx = stringx.replace("%c2%b1", "�");
        stringx = stringx.replace("%c2%b2", "�");
        stringx = stringx.replace("%c2%b3", "�");
        stringx = stringx.replace("%c2%b4", "�");
        stringx = stringx.replace("%c2%b5", "�");
        stringx = stringx.replace("%c2%b6", "�");
        stringx = stringx.replace("%c2%b7", "�");
        stringx = stringx.replace("%c2%b8", "�");
        stringx = stringx.replace("%c2%b9", "�");
        stringx = stringx.replace("%c2%ba", "�");
        stringx = stringx.replace("%c2%bb", "�");
        stringx = stringx.replace("%c2%bc", "�");
        stringx = stringx.replace("%c2%bd", "�");
        stringx = stringx.replace("%c2%be", "�");
        stringx = stringx.replace("%c2%bf", "�");
        stringx = stringx.replace("%c3%80", "�");
        stringx = stringx.replace("%c3%81", "�");
        stringx = stringx.replace("%c3%82", "�");
        stringx = stringx.replace("%c3%83", "�");
        stringx = stringx.replace("%c3%84", "�");
        stringx = stringx.replace("%c3%85", "�");
        stringx = stringx.replace("%c3%86", "�");
        stringx = stringx.replace("%c3%87", "�");
        stringx = stringx.replace("%c3%88", "�");
        stringx = stringx.replace("%c3%89", "�");
        stringx = stringx.replace("%c3%8a", "�");
        stringx = stringx.replace("%c3%8b", "�");
        stringx = stringx.replace("%c3%8c", "�");
        stringx = stringx.replace("%c3%8d", "�");
        stringx = stringx.replace("%c3%8e", "�");
        stringx = stringx.replace("%c3%8f", "�");
        stringx = stringx.replace("%c3%90", "�");
        stringx = stringx.replace("%c3%91", "�");
        stringx = stringx.replace("%c3%92", "�");
        stringx = stringx.replace("%c3%93", "�");
        stringx = stringx.replace("%c3%94", "�");
        stringx = stringx.replace("%c3%95", "�");
        stringx = stringx.replace("%c3%96", "�");
        stringx = stringx.replace("%c3%97", "�");
        stringx = stringx.replace("%c3%98", "�");
        stringx = stringx.replace("%c3%99", "�");
        stringx = stringx.replace("%c3%9a", "�");
        stringx = stringx.replace("%c3%9b", "�");
        stringx = stringx.replace("%c3%9c", "�");
        stringx = stringx.replace("%c3%9d", "�");
        stringx = stringx.replace("%c3%9e", "�");
        stringx = stringx.replace("%c3%9f", "�");
        stringx = stringx.replace("%c3%a0", "�");
        stringx = stringx.replace("%c3%a1", "�");
        stringx = stringx.replace("%c3%a2", "�");
        stringx = stringx.replace("%c3%a3", "�");
        stringx = stringx.replace("%c3%a4", "�");
        stringx = stringx.replace("%c3%a5", "�");
        stringx = stringx.replace("%c3%a6", "�");
        stringx = stringx.replace("%c3%a7", "�");
        stringx = stringx.replace("%c3%a8", "�");
        stringx = stringx.replace("%c3%a9", "�");
        stringx = stringx.replace("%c3%aa", "�");
        stringx = stringx.replace("%c3%ab", "�");
        stringx = stringx.replace("%c3%ac", "�");
        stringx = stringx.replace("%c3%ad", "�");
        stringx = stringx.replace("%c3%ae", "�");
        stringx = stringx.replace("%c3%af", "�");
        stringx = stringx.replace("%c3%b0", "�");
        stringx = stringx.replace("%c3%b1", "�");
        stringx = stringx.replace("%c3%b2", "�");
        stringx = stringx.replace("%c3%b3", "�");
        stringx = stringx.replace("%c3%b4", "�");
        stringx = stringx.replace("%c3%b5", "�");
        stringx = stringx.replace("%c3%b6", "�");
        stringx = stringx.replace("%c3%b7", "�");
        stringx = stringx.replace("%c3%b8", "�");
        stringx = stringx.replace("%c3%b9", "�");
        stringx = stringx.replace("%c3%ba", "�");
        stringx = stringx.replace("%c3%bb", "�");
        stringx = stringx.replace("%c3%bc", "�");
        stringx = stringx.replace("%c3%bd", "�");
        stringx = stringx.replace("%c3%be", "�");
        stringx = stringx.replace("%c3%bf", "�");

        return stringx;
    }

    private String getHome() {
        return replaceSpecialCharacters(getClass().getProtectionDomain()
                .getCodeSource().getLocation().toString().substring(6));
    }

    public static boolean isRunningFromJar() {
        boolean result;
        String home = privateInstance.getHome();
        // is the returned path ending with .jar?
        int lastDot = home.lastIndexOf('.');
        if (lastDot > 0 && lastDot < home.length() - 1) {
            result = home.substring(lastDot).toUpperCase().equals(".JAR");
        } else {
            result = false;
        }
        return result;
    }

    private static void copyFileFromJar(String sourceFileName, File target) {
        try {
            JarFile jar = new JarFile(privateInstance.getHome());
            ZipEntry entry = jar.getEntry(sourceFileName);

            InputStream inputStream = new BufferedInputStream(
                    jar.getInputStream(entry));
            OutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(target));
            byte[] buffer = new byte[4096];
            for (;;) {
                int nBytes = inputStream.read(buffer);
                if (nBytes <= 0)
                    break;
                outputStream.write(buffer, 0, nBytes);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog((Component) null, e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog((Component) null, e);
        }
    }

    private static void copyFileFromFileSystem(String sourceFileName,
            File target) {
        try {
            File in = new File("./Ressources/" + sourceFileName);
            FileChannel inChannel = new FileInputStream(in).getChannel();
            FileChannel outChannel = new FileOutputStream(target).getChannel();
            try {
                inChannel.transferTo(0, inChannel.size(), outChannel);
            } catch (IOException e) {
                throw e;
            } finally {
                if (inChannel != null)
                    inChannel.close();
                if (outChannel != null)
                    outChannel.close();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog((Component) null, e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog((Component) null, e);
        }
    }

    public static void copyFile(String sourceFileName, File target) {
        if (isRunningFromJar()) {
            copyFileFromJar(sourceFileName, target);
        } else {
            copyFileFromFileSystem(sourceFileName, target);
        }
    }

    private static String getStringFromJar(String ressourceIdentifier) {
        StringBuffer result = new StringBuffer();
        try {
            JarFile jar = new JarFile(privateInstance.getHome());
            ZipEntry entry = jar.getEntry(ressourceIdentifier);

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(jar.getInputStream(entry)));

            String newLine;
            while ((newLine = inputReader.readLine()) != null) {
                result.append(newLine);
            }
            inputReader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog((Component) null, e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog((Component) null, e);
        }

        return result.toString();
    }

    private static String getStringFromFileSystem(String ressourceIdentifier) {
        StringBuffer result = new StringBuffer();
        try {
            File in = new File("./Ressources/" + ressourceIdentifier);

            BufferedReader inputReader = new BufferedReader(new FileReader(in));

            String newLine;
            while ((newLine = inputReader.readLine()) != null) {
                result.append(newLine);
            }
            inputReader.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog((Component) null, e);
        } catch (IOException e) {
            JOptionPane.showMessageDialog((Component) null, e);
        }

        return result.toString();
    }

    public static String getStringFromRessource(String ressourceIdentifier) {
        if (isRunningFromJar()) {
            return getStringFromJar(ressourceIdentifier);
        } else {
            return getStringFromFileSystem(ressourceIdentifier);
        }
    }
}
