package com.spirit.shit.console;

import com.spirit.shit.ShitMod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@SuppressWarnings("unused")
public class RepositoryLogger {

    public static void logInitializedClasses(Class<?>[] initializedClasses) {
        String repositoryPath = "the-shit-of-crypt/src"; // Change this to the actual path of your repository

        ShitMod.LOGGER.info(">> /-------------------------------------------------------------------------------------------------------------------------------------");
        ShitMod.LOGGER.info(">> | Loading initialized classes files...");
        ShitMod.LOGGER.info(">> | ------------------------------------------------------------------------------------------------------------------------------------");
        ShitMod.LOGGER.info(">> | Preparing to loading initialized java classes...");

        List<String> loadedFiles = new ArrayList<>();
        AtomicInteger totalFiles = new AtomicInteger();
        final long[] totalSize = {0}; // Initialize total size variable
        AtomicLong totalCharacters = new AtomicLong(); // Initialize total characters variable
        AtomicLong totalLines = new AtomicLong(); // Initialize total lines variable
        long startTime = System.currentTimeMillis(); // Capture start time
        Map<String, Integer> fileTypeCounts = new HashMap<>(); // Map to store file type counts

        try {
            Files.walkFileTree(Paths.get(repositoryPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file)) {
                        String relativePath = Paths.get(repositoryPath).relativize(file).toString();
                        long fileSize = Files.size(file);
                        loadedFiles.add(relativePath);
                        totalSize[0] += fileSize; // Add the file size to the total size

                        // Read and count characters and lines from the file
                        try (InputStream inputStream = Files.newInputStream(file);
                             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                            long charactersInFile = 0;
                            long linesInFile = 0;
                            String line;
                            while ((line = reader.readLine()) != null) {
                                charactersInFile += line.length();
                                linesInFile++;
                            }
                            totalCharacters.addAndGet(charactersInFile);
                            totalLines.addAndGet(linesInFile);
                        }

                        // Get the file type (extension) and count it
                        String fileType = getExtension(relativePath);
                        fileTypeCounts.put(fileType, fileTypeCounts.getOrDefault(fileType, 0) + 1);
                    }
                    totalFiles.incrementAndGet();
                    return FileVisitResult.CONTINUE;
                }
            });

            for (Class<?> clazz : initializedClasses) {
                String className = clazz.getName();
                String packageName = className.substring(0, className.lastIndexOf('.'));
                String filePath = packageName.replace('.', '/') + "/" + className.substring(className.lastIndexOf('.') + 1) + ".java";
                loadedFiles.add(filePath);
                totalFiles.incrementAndGet();
                // Calculate characters in the class name (including package name)
                totalCharacters.addAndGet(className.length());
            }
            ShitMod.LOGGER.info(">> | Beginning to loading java classes...");
            Collections.sort(loadedFiles);

            int count = 0;
            for (String loadedFile : loadedFiles) {
                count++;
                double progress = (double) count / totalFiles.get() * 100;
                ShitMod.LOGGER.info("[" + String.format("%.2f", progress) + "%] >> | " + loadedFile);
            }

            long endTime = System.currentTimeMillis(); // Capture end time
            long elapsedTime = endTime - startTime; // Calculate elapsed time
            ShitMod.LOGGER.info(">> +-------------------------------------------------------------------------------------------------------------------------------------");

            ShitMod.LOGGER.info(">> | Total Size: " + totalSize[0] + " bytes | Total Characters: " + totalCharacters.get() + " | Total Lines: " + totalLines.get() + " | Elapsed Time: " + elapsedTime + " ms | Files Loaded: " + totalFiles.get());

            // Display the count of each file type
            ShitMod.LOGGER.info(">> | Total classes file types:");
            for (Map.Entry<String, Integer> entry : fileTypeCounts.entrySet()) {
                ShitMod.LOGGER.info(">> | " + entry.getKey() + ": " + entry.getValue());
            }

            ShitMod.LOGGER.info(">> | Finished loading java classes");
        } catch (IOException ignored) {
        }
    }

    public static void logInitializedCPPClasses(Class<?>[] initializedClasses) {
        String repositoryPath = "the-shit-of-crypt/src/client/c++"; // Change this to the actual path of your repository

        ShitMod.LOGGER.info(">> | ------------------------------------------------------------------------------------------------------------------------------------");
        ShitMod.LOGGER.info(">> | Preparing to loading initialized c++ classes...");

        List<String> loadedFiles = new ArrayList<>();
        AtomicInteger totalFiles = new AtomicInteger();
        final long[] totalSize = {0}; // Initialize total size variable
        AtomicLong totalCharacters = new AtomicLong(); // Initialize total characters variable
        AtomicLong totalLines = new AtomicLong(); // Initialize total lines variable
        long startTime = System.currentTimeMillis(); // Capture start time
        Map<String, Integer> fileTypeCounts = new HashMap<>(); // Map to store file type counts

        try {
            Files.walkFileTree(Paths.get(repositoryPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file)) {
                        String relativePath = Paths.get(repositoryPath).relativize(file).toString();
                        long fileSize = Files.size(file);
                        loadedFiles.add(relativePath);
                        totalSize[0] += fileSize; // Add the file size to the total size

                        // Read and count characters and lines from the file
                        try (InputStream inputStream = Files.newInputStream(file);
                             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                            long charactersInFile = 0;
                            long linesInFile = 0;
                            String line;
                            while ((line = reader.readLine()) != null) {
                                charactersInFile += line.length();
                                linesInFile++;
                            }
                            totalCharacters.addAndGet(charactersInFile);
                            totalLines.addAndGet(linesInFile);
                        }

                        // Get the file type (extension) and count it
                        String fileType = getExtension(relativePath);
                        fileTypeCounts.put(fileType, fileTypeCounts.getOrDefault(fileType, 0) + 1);
                    }
                    totalFiles.incrementAndGet();
                    return FileVisitResult.CONTINUE;
                }
            });

            for (Class<?> clazz : initializedClasses) {
                String className = clazz.getName();
                String packageName = className.substring(0, className.lastIndexOf('.'));
                String filePath = packageName.replace('.', '/') + "/" + className.substring(className.lastIndexOf('.') + 1) + ".java";
                loadedFiles.add(filePath);
                totalFiles.incrementAndGet();
                // Calculate characters in the class name (including package name)
                totalCharacters.addAndGet(className.length());
            }
            ShitMod.LOGGER.info(">> | Beginning to loading c++ classes...");
            Collections.sort(loadedFiles);

            int count = 0;
            for (String loadedFile : loadedFiles) {
                count++;
                double progress = (double) count / totalFiles.get() * 100;
                ShitMod.LOGGER.info("[" + String.format("%.2f", progress) + "%] >> | " + loadedFile);
            }

            long endTime = System.currentTimeMillis(); // Capture end time
            long elapsedTime = endTime - startTime; // Calculate elapsed time
            ShitMod.LOGGER.info(">> | ------------------------------------------------------------------------------------------------------------------------------------");

            ShitMod.LOGGER.info(">> | Total Size: " + totalSize[0] + " bytes | Total Characters: " + totalCharacters.get() + " | Total Lines: " + totalLines.get() + " | Elapsed Time: " + elapsedTime + " ms | Files Loaded: " + totalFiles.get());

            // Display the count of each file type
            ShitMod.LOGGER.info(">> | Total classes file types:");
            for (Map.Entry<String, Integer> entry : fileTypeCounts.entrySet()) {
                ShitMod.LOGGER.info(">> | " + entry.getKey() + ": " + entry.getValue());
            }

            ShitMod.LOGGER.info(">> | Finished loading c++ classes");
        } catch (IOException ignored) {
        }
    }

    public static void logInitializedResourceClasses(Class<?>[] initializedClasses) {
        String repositoryPath = "the-shit-of-crypt/src/client/resources"; // Change this to the actual path of your repository

        ShitMod.LOGGER.info(">> +-------------------------------------------------------------------------------------------------------------------------------------");
        ShitMod.LOGGER.info(">> | Loading initialized resource files...");

        List<String> loadedFiles = new ArrayList<>();
        AtomicInteger totalFiles = new AtomicInteger();
        final long[] totalSize = {0}; // Initialize total size variable
        AtomicLong totalCharacters = new AtomicLong(); // Initialize total characters variable
        AtomicLong totalLines = new AtomicLong(); // Initialize total lines variable
        long startTime = System.currentTimeMillis(); // Capture start time
        Map<String, Integer> fileTypeCounts = new HashMap<>(); // Map to store file type counts

        try {
            Files.walkFileTree(Paths.get(repositoryPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file)) {
                        String relativePath = Paths.get(repositoryPath).relativize(file).toString();
                        long fileSize = Files.size(file);
                        loadedFiles.add(relativePath);
                        totalSize[0] += fileSize; // Add the file size to the total size

                        // Read and count characters and lines from the file
                        try (InputStream inputStream = Files.newInputStream(file);
                             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                            long charactersInFile = 0;
                            long linesInFile = 0;
                            String line;
                            while ((line = reader.readLine()) != null) {
                                charactersInFile += line.length();
                                linesInFile++;
                            }
                            totalCharacters.addAndGet(charactersInFile);
                            totalLines.addAndGet(linesInFile);
                        }

                        // Get the file type (extension) and count it
                        String fileType = getExtension(relativePath);
                        fileTypeCounts.put(fileType, fileTypeCounts.getOrDefault(fileType, 0) + 1);
                    }
                    totalFiles.incrementAndGet();
                    return FileVisitResult.CONTINUE;
                }
            });

            for (Class<?> clazz : initializedClasses) {
                String className = clazz.getName();
                String packageName = className.substring(0, className.lastIndexOf('.'));
                String filePath = packageName.replace('.', '/') + "/" + className.substring(className.lastIndexOf('.') + 1) + ".java";
                loadedFiles.add(filePath);
                totalFiles.incrementAndGet();
                // Calculate characters in the class name (including package name)
                totalCharacters.addAndGet(className.length());
            }
            ShitMod.LOGGER.info(">> | Preparing loading resource files in background...");
            ShitMod.LOGGER.info(">> | Beginning loading resource files in background...");
            Collections.sort(loadedFiles);

            int count = 0;
            for (String loadedFile : loadedFiles) {
                count++;
                double progress = (double) count / totalFiles.get() * 100;
            }

            long endTime = System.currentTimeMillis(); // Capture end time
            long elapsedTime = endTime - startTime; // Calculate elapsed time

            ShitMod.LOGGER.info(">> | Total Size: " + totalSize[0] + " bytes | Total Characters: " + totalCharacters.get() + " | Total Lines: " + totalLines.get() + " | Elapsed Time: " + elapsedTime + " ms | Files Loaded: " + totalFiles.get());

            // Display the count of each file type
            ShitMod.LOGGER.info(">> | Total resource files Types:");
            for (Map.Entry<String, Integer> entry : fileTypeCounts.entrySet()) {
                ShitMod.LOGGER.info(">> | " + entry.getKey() + ": " + entry.getValue());
            }

            ShitMod.LOGGER.info(">> | Finished loading resource files");
            ShitMod.LOGGER.info(">> +-------------------------------------------------------------------------------------------------------------------------------------");

        } catch (IOException ignored) {
        }
    }

    public static void logInitializedFullClasses(Class<?>[] initializedClasses) {
        String repositoryPath = "the-shit-of-crypt/src/"; // Change this to the actual path of your repository

        List<String> loadedFiles = new ArrayList<>();
        AtomicInteger totalFiles = new AtomicInteger();
        final long[] totalSize = {0}; // Initialize total size variable
        AtomicLong totalCharacters = new AtomicLong(); // Initialize total characters variable
        AtomicLong totalLines = new AtomicLong(); // Initialize total lines variable
        long startTime = System.currentTimeMillis(); // Capture start time
        Map<String, Integer> fileTypeCounts = new HashMap<>(); // Map to store file type counts

        try {
            Files.walkFileTree(Paths.get(repositoryPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file)) {
                        String relativePath = Paths.get(repositoryPath).relativize(file).toString();
                        long fileSize = Files.size(file);
                        loadedFiles.add(relativePath);
                        totalSize[0] += fileSize; // Add the file size to the total size

                        // Read and count characters and lines from the file
                        try (InputStream inputStream = Files.newInputStream(file);
                             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                            long charactersInFile = 0;
                            long linesInFile = 0;
                            String line;
                            while ((line = reader.readLine()) != null) {
                                charactersInFile += line.length();
                                linesInFile++;
                            }
                            totalCharacters.addAndGet(charactersInFile);
                            totalLines.addAndGet(linesInFile);
                        }

                        // Get the file type (extension) and count it
                        String fileType = getExtension(relativePath);
                        fileTypeCounts.put(fileType, fileTypeCounts.getOrDefault(fileType, 0) + 1);
                    }
                    totalFiles.incrementAndGet();
                    return FileVisitResult.CONTINUE;
                }
            });

            for (Class<?> clazz : initializedClasses) {
                String className = clazz.getName();
                String packageName = className.substring(0, className.lastIndexOf('.'));
                String filePath = packageName.replace('.', '/') + "/" + className.substring(className.lastIndexOf('.') + 1) + ".java";
                loadedFiles.add(filePath);
                totalFiles.incrementAndGet();
                // Calculate characters in the class name (including package name)
                totalCharacters.addAndGet(className.length());
            }
            Collections.sort(loadedFiles);

            int count = 0;
            for (String loadedFile : loadedFiles) {
                count++;
                double progress = (double) count / totalFiles.get() * 100;
            }

            long endTime = System.currentTimeMillis(); // Capture end time
            long elapsedTime = endTime - startTime; // Calculate elapsed time
            ShitMod.LOGGER.info(">> | Full repo files:");

            ShitMod.LOGGER.info(">> | Total Size: " + totalSize[0] + " bytes | Total Characters: " + totalCharacters.get() + " | Total Lines: " + totalLines.get() + " | Elapsed Time: " + elapsedTime + " ms | Files Loaded: " + totalFiles.get());

            // Display the count of each file type
            ShitMod.LOGGER.info(">> | Total File Types:");
            for (Map.Entry<String, Integer> entry : fileTypeCounts.entrySet()) {
                ShitMod.LOGGER.info(">> | " + entry.getKey() + ": " + entry.getValue());
            }

            ShitMod.LOGGER.info(">> \\+------------------------------------------------------------------------------------------------------------------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to get file extension
    private static String getExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1) {
            return fileName.substring(dotIndex + 1);
        }
        return ""; // No extension found
    }
}
