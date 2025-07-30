import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class main_once_v1 {

    public static void main(String[] args) {

        String homeworkDirStr = args[0];
        String studentFileName = args[1];
        String testerDirStr = args[2];
        String classID = args[3];
        String homeworkID = args[4];

        Path homeworkDir = Paths.get(homeworkDirStr);
        Path studentJavaFile = homeworkDir.resolve(studentFileName);
        Path testerDir = Paths.get(testerDirStr);

        if (!Files.exists(studentJavaFile) || !Files.exists(testerDir)) {
            System.out.println("01");
            return;
        }

        String actualClassName = null;

        try {
            boolean compileSuccess = compileJavaFile(studentJavaFile, homeworkDir);
            if (!compileSuccess) {
                System.out.println("02");
                return;
            }

            actualClassName = findMainClassName(homeworkDir);
            if (actualClassName == null) {
                System.out.println("06");
                return;
            }

            List<File> outputFiles = Files.list(testerDir)
                    .filter(p -> p.toString().endsWith(".out"))
                    .map(Path::toFile)
                    .sorted(Comparator.comparing(File::getName))
                    .collect(Collectors.toList());

            if (outputFiles.isEmpty()) {
                System.out.println("03");
                return;
            }

            for (File testCaseOutFile : outputFiles) {
                boolean pass = runAndCompare(homeworkDir, actualClassName, testerDir, testCaseOutFile);
                if (!pass) {
                    System.out.println("04");
                    return;
                }
            }

            System.out.println("1");

        } catch (Exception e) {
            System.out.println("05");
        } finally {
            if (actualClassName != null) {
                clearClassFile(homeworkDir, actualClassName);
            }
            clearAllClassFiles(homeworkDir);
        }
    }

    private static boolean compileJavaFile(Path javaFile, Path workingDir) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("javac", "-encoding", "UTF-8", javaFile.toString());
        pb.directory(workingDir.toFile());
        pb.redirectErrorStream(true);
        Process process = pb.start();

        StringBuilder compilerOutput = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                compilerOutput.append(line).append(System.lineSeparator());
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.err.println("Compilation Error:\n" + compilerOutput.toString());
        }
        return exitCode == 0;
    }

    private static String findMainClassName(Path homeworkDir) throws IOException {
        List<String> mainClasses = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(homeworkDir, "*.class")) {
            for (Path entry : stream) {
                String fileName = entry.getFileName().toString();
                String className = fileName.replace(".class", "");

                try {
                    ProcessBuilder pb = new ProcessBuilder("javap", "-public", "-l", "-s", "-v", className);
                    pb.directory(homeworkDir.toFile());
                    pb.redirectErrorStream(true);

                    Process process = pb.start();
                    StringBuilder javapOutput = new StringBuilder();
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            javapOutput.append(line);
                        }
                    }
                    process.waitFor();

                    if (javapOutput.toString().contains("public static void main(java.lang.String[])")) {
                        mainClasses.add(className);
                    }

                } catch (Exception e) {
                }
            }
        }

        if (mainClasses.size() == 1) {
            return mainClasses.get(0);
        } else if (mainClasses.size() > 1) {
            System.err.println("Error: Found multiple main classes: " + String.join(", ", mainClasses));
            return null;
        } else {
            return null;
        }
    }

    private static boolean runAndCompare(Path workingDir, String className, Path testerDir, File outFile) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("java", className);
        pb.directory(workingDir.toFile());

        String testName = outFile.getName().replace(".out", "");
        Path inFile = testerDir.resolve(testName + ".in");

        if (Files.exists(inFile)) {
            pb.redirectInput(inFile.toFile());
        }

        Process process = pb.start();

        List<String> actualOutput = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                actualOutput.add(line);
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"))) {
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    System.err.println("Runtime Error (Student Program): " + errorLine);
                }
            }
            return false;
        }

        List<String> expectedOutput = Files.readAllLines(outFile.toPath(), java.nio.charset.StandardCharsets.UTF_8);

        return actualOutput.equals(expectedOutput);
    }

    private static void clearClassFile(Path workingDir, String className) {
        try {
            Path classFile = workingDir.resolve(className + ".class");
            Files.deleteIfExists(classFile);
        } catch (IOException e) {
        }
    }

    private static void clearAllClassFiles(Path workingDir) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(workingDir, "*.class")) {
            for (Path entry : stream) {
                try {
                    Files.deleteIfExists(entry);
                } catch (IOException e) {
                }
            }
        } catch (IOException e) {
        }
    }
}
