package cj.mf.commonsclitut;

import org.apache.commons.cli.*;

import static java.lang.System.exit;

/**
 * Hello world!
 */
public class App {

    private static String logfile;
    private static String logger;
    private static String listener;
    private static String buildfile;
    private static String find;

    public static void main(String[] args) {
        Options options = new Options()
                .addOption(Option.builder("h")
                        .longOpt("help")
                        .desc("print this help message")
                        .build())
                .addOption(Option.builder("g")
                        .argName("file")
                        .hasArg()
                        .desc("use given file for log")
                        .longOpt("logfile")
                        .build())
                .addOption(Option.builder("G")
                        .argName("classname")
                        .hasArg()
                        .desc("the class which is to perform logging")
                        .longOpt("logger")
                        .build())
                .addOption(Option.builder("l")
                        .argName("classname")
                        .hasArg()
                        .desc("add an instance of class as a project listener")
                        .longOpt("listener")
                        .build())
                .addOption(Option.builder("b")
                        .argName("file")
                        .hasArg()
                        .desc("use given buildfile")
                        .longOpt("buildfile")
                        .build())
                .addOption(Option.builder("f")
                        .argName("file")
                        .hasArg()
                        .desc("search for buildfile towards the root of the filesystem and use it")
                        .longOpt("find")
                        .build());

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(options, args);

            if (line.hasOption("logfile")) {
                logfile = line.getOptionValue("logfile");
            }
            if (line.hasOption("logger")) {
                logger = line.getOptionValue("logger");
            }
            if (line.hasOption("listener")) {
                listener = line.getOptionValue("listener");
            }
            if (line.hasOption("buildfile")) {
                buildfile = line.getOptionValue("buildfile");
            }
            if (line.hasOption("find")) {
                find = line.getOptionValue("find");
            }
            if (line.hasOption("help")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("commonsclitut", options);
                exit(-1);
            }
        } catch (ParseException e) {
            System.err.println("error parsing: " + e);
        }

        System.out.printf("Set args:\n\tlogfile: %s\n\tlogger: %s\n\tlistener: %s\n\tbuildfile: %s\n\tfind: %s\n\t",
                logfile, logger, listener, buildfile, find);
    }
}
