package com.spirit.koil.api.quilt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static com.spirit.Main.*;
import static org.apache.commons.io.FilenameUtils.getExtension;

public class Quilt {







    public static void logQuiltBridge(String modsLocation) {
        blockTextBuilder.append("""
            
            Bridging Quilt to Koil [Fabrickoil]...
            """);

        List<String> loadedFiles = new ArrayList<>();
        AtomicInteger totalFiles = new AtomicInteger();
        final long[] totalSize = {0}; // Initialize total size variable
        AtomicLong totalCharacters = new AtomicLong(); // Initialize total characters variable
        AtomicLong totalLines = new AtomicLong(); // Initialize total lines variable
        long startTime = System.currentTimeMillis(); // Capture start time
        Map<String, Integer> fileTypeCounts = new HashMap<>(); // Map to store file type counts

        try {
            Files.walkFileTree(Paths.get(modsLocation), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file)) {
                        String relativePath = modsLocation + "/" + Paths.get(modsLocation).relativize(file).toString();
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

            Collections.sort(loadedFiles);

            for (String loadedFile : loadedFiles) {
                double fileSize = Files.size(Paths.get(loadedFile));
                long fileLoadTime = System.currentTimeMillis() - startTime;
                blockTextBuilder.append("(Quilt) | ").append(loadedFile).append(" - took ").append(formatTime(fileLoadTime)).append(" (").append(formatFileSize(fileSize)).append(")\n");
            }

            long endTime = System.currentTimeMillis(); // Capture end time
            long elapsedTime = endTime - startTime; // Calculate elapsed time
            blockTextBuilder.append("+------------------------------------------------------------------------------------------------------------------------------------------------------------------+\n");
            blockTextBuilder.append("Total Size: ").append(formatFileSize(totalSize[0])).append(" | Total Characters: ").append(totalCharacters.get()).append(" | Total Lines: ").append(totalLines.get()).append(" | Elapsed Time: ").append(formatTime(elapsedTime)).append(" | Files Loaded: ").append(totalFiles.get()).append("\n");

            // Display the count of each file type
            blockTextBuilder.append("Total classes file types:\n");
            for (Map.Entry<String, Integer> entry : fileTypeCounts.entrySet()) {
                blockTextBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }

            blockTextBuilder.append("Finished bridging Quilt!\n");
        } catch (IOException ignored) {
        }

        blockTextBuilder.append("""
            ====================================================================================================================================================================
            """);
        System.out.println(blockTextBuilder.toString());
    }

    private static String getName() {
        return null;
    }
}
